package com.imooc.controller.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by TongHaiJun
 * 2019/8/14 22:07
 */
@Data
public class ProductForm {

    /**
     * 商品id.
     */
    private String productId;

    /**
     * 商品名称.
     */
    private String productName;

    /**
     * 商品单价.
     */
    private BigDecimal productPrice;

    /**
     * 商品库存.
     */
    private Integer productStock;

    /**
     * 商品描述.
     */
    private String productDescription;

    /**
     * 商品小图.
     */
    private String productIcon;

    /**
     * 类目编号.
     */
    private Integer categoryType;

}
