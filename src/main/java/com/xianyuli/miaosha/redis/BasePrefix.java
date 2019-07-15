package com.xianyuli.miaosha.redis;


public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;
    private String prifix;

    //永不过期
    public BasePrefix(String prifix) {
        this(0,prifix);
    }

    public BasePrefix(int expireSeconds, String prifix) {
        this.expireSeconds = expireSeconds;
        this.prifix = prifix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" +prifix+":";
    }
}
