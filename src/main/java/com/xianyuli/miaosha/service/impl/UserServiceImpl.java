package com.xianyuli.miaosha.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.xianyuli.miaosha.commons.UserConst;
import com.xianyuli.miaosha.dao.UserDao;
import com.xianyuli.miaosha.domain.RushUser;
import com.xianyuli.miaosha.redis.RedisClient;
import com.xianyuli.miaosha.redis.key.UserKey;
import com.xianyuli.miaosha.result.CodeMsg;
import com.xianyuli.miaosha.result.Result;
import com.xianyuli.miaosha.service.UserService;
import com.xianyuli.miaosha.utils.MD5utils;
import com.xianyuli.miaosha.vo.LoginUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RedisClient redisClient;


    @Override
    public Result login(HttpServletResponse response, LoginUserVO loginUserVO) {
        RushUser user = userDao.getUserById(Long.valueOf(loginUserVO.getMobile()));
        String inputPass = loginUserVO.getPassword();
        if (user == null) {
            return Result.error(CodeMsg.MOBILE_NOT_EXIST);
        } else if (StrUtil.isEmpty(user.getPassword())) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        String dbPass = user.getPassword();
        String salt = user.getSalt();
        String inputDbPass = MD5utils.formPassToDBPass(inputPass, salt);
        if (dbPass == null || !dbPass.equals(inputDbPass)) {
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }

        setCookie(user, response);
        return Result.success("登录成功");
    }

    @Override
    public RushUser getUserByToken(HttpServletResponse response, String token) {
        if (StrUtil.isEmpty(token)) {
            return null;
        }
        RushUser user = redisClient.get(UserKey.USERTOKEN, token, RushUser.class);
        if (user != null) {
            //延长cookie
            setCookie(user, response);
        }
        return user;
    }


    private void setCookie(RushUser user, HttpServletResponse response) {
        //生产token
        String token = IdUtil.simpleUUID();
        redisClient.set(UserKey.USERTOKEN, token, user);
        Cookie cookie = new Cookie(UserConst.token.COOKIENAME, token);
        cookie.setMaxAge(UserKey.USERTOKEN.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
