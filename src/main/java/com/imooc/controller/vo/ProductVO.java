package com.imooc.controller.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * Created by TongHaiJun
 * 2019/7/29 21:02
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -9205442173351621231L;

    /**
     * 类目名称.
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 类目编号.
     */
    @JsonProperty("type")
    private Integer categoryType;

    /**
     * 类目下的商品列表.
     */
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVoList;

}
