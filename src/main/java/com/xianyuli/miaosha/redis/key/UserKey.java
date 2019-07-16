package com.xianyuli.miaosha.redis.key;

import com.xianyuli.miaosha.commons.UserConst;
import com.xianyuli.miaosha.redis.BasePrefix;

public class UserKey extends BasePrefix {


    private UserKey(int expireSeconds, String prifix) {
        super(expireSeconds, prifix);
    }

    private UserKey(String prifix) {
        super(prifix);
    }

    public static final UserKey GETBYID = new UserKey("ID");
    public static final UserKey GETBYNAME = new UserKey("NAME");
    public static final UserKey USERTOKEN = new UserKey(UserConst.token.COOKIEAGE, "TOKEN");
}
