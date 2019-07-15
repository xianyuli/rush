package com.xianyuli.miaosha.service;

import com.xianyuli.miaosha.result.Result;
import com.xianyuli.miaosha.vo.LoginUserVO;


public interface UserService {

    public Result login(LoginUserVO loginUserVO);

}
