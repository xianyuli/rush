package com.xianyuli.miaosha.vo;

import com.xianyuli.miaosha.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoginUserVO {
    @NotNull(message = "手机号码为空！")
    @IsMobile
    private String mobile;

    @NotNull(message = "密码为空！")
    @Length(max = 32)
    private String password;
}
