package com.imooc.constant;

/**
 * redis常量
 * Created by TongHaiJun
 * 2019/8/17 20:16
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    Integer EXPIRE = 7200; // 2小时
}
