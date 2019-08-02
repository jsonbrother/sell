package com.imooc.dao.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 商品.
 * Created by TongHaiJun
 * 2019/7/29 19:51
 */
@Entity
@Data
@Table(name = "tb_product_info")
public class ProductInfo {

    /**
     * 商品id.
     */
    @Id
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
     * 商品状态 0-正常 1-下架
     */
    private Integer productStatus;

    /**
     * 类目编号.
     */
    private Integer categoryType;

    public ProductInfo() {
    }
}
