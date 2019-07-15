package com.xianyuli.miaosha.service.impl;

import cn.hutool.core.util.StrUtil;
import com.xianyuli.miaosha.dao.UserDao;
import com.xianyuli.miaosha.domain.RushUser;
import com.xianyuli.miaosha.result.CodeMsg;
import com.xianyuli.miaosha.result.Result;
import com.xianyuli.miaosha.service.UserService;
import com.xianyuli.miaosha.utils.MD5utils;
import com.xianyuli.miaosha.vo.LoginUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Result login(LoginUserVO loginUserVO) {
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
        return Result.success("登录成功");
    }
}
