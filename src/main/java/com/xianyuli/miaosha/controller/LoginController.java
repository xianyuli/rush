package com.xianyuli.miaosha.controller;


import com.xianyuli.miaosha.result.Result;
import com.xianyuli.miaosha.service.UserService;
import com.xianyuli.miaosha.vo.LoginUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;


    @RequestMapping("/tologin")
    public String toLogin() {
        return "login";
    }

    @ResponseBody
    @RequestMapping("/dologin")
    public Result doLogin(HttpServletResponse response, @Valid LoginUserVO loginUserVO) {
        return userService.login(response, loginUserVO);
    }

}
