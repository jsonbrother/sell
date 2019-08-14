package com.imooc.controller.form;

import lombok.Data;

/**
 * Created by TongHaiJun
 * 2019/8/14 23:33
 */
@Data
public class CategoryForm {

    /**
     * 类目id.
     */
    private Integer categoryId;

    /**
     * 类目名称.
     */
    private String categoryName;

    /**
     * 类目编号.
     */
    private Integer categoryType;
}
