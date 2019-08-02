package com.imooc.service;


import com.imooc.dao.po.ProductCategory;

import java.util.List;

/**
 * Created by TongHaiJun
 * 2019/7/28 22:29
 */
public interface ICategoryService {

    ProductCategory save(ProductCategory productCategory);

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
