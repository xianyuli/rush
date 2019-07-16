package com.xianyuli.miaosha.service;

import com.xianyuli.miaosha.domain.RushUser;
import com.xianyuli.miaosha.result.Result;
import com.xianyuli.miaosha.vo.LoginUserVO;

import javax.servlet.http.HttpServletResponse;


public interface UserService {

    Result login(HttpServletResponse response, LoginUserVO loginUserVO);

    RushUser getUserByToken(HttpServletResponse response, String token);

}
