package com.xianyuli.miaosha.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class RushUser {
    private Long id;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;
}
