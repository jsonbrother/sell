package com.imooc.constant;

/**
 * WeChat推送常量
 * Created by TongHaiJun
 * 2019/8/18 2:24
 */
public interface WeChatPushConstant {

    /**
     * 订单推送模板
     */
    String ORDER_TEMPLATE = "orderStatus";
    String FIRST = "first";
    String KEY_WORD_ONE = "keyword1";
    String KEY_WORD_TWO = "keyword2";
    String KEY_WORD_THREE = "keyword3";
    String KEY_WORD_FOUR = "keyword4";
    String KEY_WORD_FIVES = "keyword5";
    String REMARK = "remark";

    /**
     * 商家名称
     */
    String MERCHANT_NAME = "微信点餐";
    /**
     * 商家电话
     */
    String MERCHANT_PHONE = "17800000001";

    String ORDER_FIRST_VALUE = "亲，请记得收货。";
    String ORDER_REMARK_VALUE = "欢迎再次光临！";
}
