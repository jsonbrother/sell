package com.imooc.service.dto;

import lombok.Data;

/**
 * 购物车.
 * Created by TongHaiJun
 * 2019/8/1 0:05
 */
@Data
public class CartDTO {

    /**
     * 商品id.
     */
    private String productId;

    /**
     * 商品数量.
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
