package com.xianyuli.miaosha.controller;


import com.xianyuli.miaosha.domain.RushUser;
import com.xianyuli.miaosha.redis.RedisClient;
import com.xianyuli.miaosha.redis.key.UserKey;
import com.xianyuli.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class SampleController {
/*
    @Autowired
    UserService userService;

    @Autowired
    RedisClient redisClient;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "LW");
        return "hello";
    }

    @RequestMapping("/get")
    @ResponseBody
    public RushUser getById() {
        RushUser user = userService.getById();
        return user;
    }

    @RequestMapping("/tx")
    @ResponseBody
    public void tx() {
        userService.tx();
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public boolean set() {
        RushUser user = new RushUser();
        user.setId(1);
        user.setName("first one");
        boolean flag = redisClient.set(UserKey.GETBYID, user.getId()+"", user);
        return flag;
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public String get() {
        String value = redisClient.get(UserKey.GETBYID, "1", String.class);
        return value;
    }*/

}
