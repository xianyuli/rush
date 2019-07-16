package com.xianyuli.miaosha.controller;

import cn.hutool.core.util.StrUtil;
import com.xianyuli.miaosha.commons.UserConst;
import com.xianyuli.miaosha.domain.RushUser;
import com.xianyuli.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: rush
 * @Package: com.xianyuli.miaosha.controller
 * @ClassName: GoodsController
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2019/7/16 0016 23:13
 * @UpdateUser: LW
 * @UpdateDate: 2019/7/16 0016 23:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list")
    public String tolist(
            HttpServletResponse response,
            Model model,
            @CookieValue(name = UserConst.token.COOKIENAME, required = false) String token) {
        if (StrUtil.isEmpty(token)) {
            return "login";
        }

        RushUser user = userService.getUserByToken(response, token);
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        return "list";
    }
}
