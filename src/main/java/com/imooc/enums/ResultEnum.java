package com.imooc.enums;

import lombok.Getter;

/**
 * Created by TongHaiJun
 * 2019/7/31 23:44
 */
@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),

    PARAM_ERROR(10001,"参数不正确"),

    PRODUCT_NOT_EXIST(20001,"商品不存在"),

    PRODUCT_STOCK_ERROR(20002,"商品库存不正确"),

    ORDER_NOT_EXIST(30001,"订单不存在"),

    ORDER_DETAIL_NOT_EXIST(30002,"订单详细不存在"),

    ORDER_STATUS_ERROR(30003,"订单状态不正确"),

    ORDER_UPDATE_FAIL(30004,"订单更新失败"),

    ORDER_DETAIL_EMPTY(30005,"订单详细为空"),

    ORDER_PAY_STATUS_ERROR(30006,"订单支付状态不正确"),

    ORDER_CANCEL_SUCCESS(30007,"订单取消成功"),

    ORDER_FINISH_SUCCESS(30008,"订单完结成功"),

    CART_EMPTY(30007,"购物车不能为空"),

    ORDER_OWNER_ERROR(30009,"该订单不属于当前用户"),

    WX_MP_ERROR(40001,"微信公众账号方面错误"),

    WX_PAY_NOTIFY_MONEY_VERIFY_ERROR(40002,"微信支付异步通知金额校验不通过");

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
