package com.imooc.enums;

import lombok.Getter;

/**
 * Created by TongHaiJun
 * 2019/7/31 22:40
 */
@Getter
public enum PayStatusEnum implements CodeEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
