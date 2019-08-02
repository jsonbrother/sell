package com.imooc.service.impl;

import com.imooc.dao.IProductCategoryDao;
import com.imooc.dao.po.ProductCategory;
import com.imooc.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TongHaiJun
 * 2019/7/28 22:33
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private IProductCategoryDao iProductCategoryDao;

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return iProductCategoryDao.save(productCategory);
    }

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return iProductCategoryDao.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return iProductCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return iProductCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }
}
