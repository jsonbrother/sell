package com.imooc.controller.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详细
 * Created by TongHaiJun
 * 2019/7/29 21:07
 */
@Data
public class ProductInfoVO {

    /**
     * 商品id.
     */
    @JsonProperty("id")
    private String productId;

    /**
     * 商品名称.
     */
    @JsonProperty("name")
    private String productName;

    /**
     * 商品单价.
     */
    @JsonProperty("price")
    private BigDecimal productPrice;


    /**
     * 商品描述.
     */
    @JsonProperty("description")
    private String productDescription;

    /**
     * 商品小图.
     */
    @JsonProperty("icon")
    private String productIcon;
}
