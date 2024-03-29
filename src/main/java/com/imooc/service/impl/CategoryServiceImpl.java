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
        // TODO 类目的新增、修改 需要判断类目编号是否存在 商品是否选择 待优化
        return iProductCategoryDao.save(productCategory);
    }

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return iProductCategoryDao.findById(categoryId).orElse(null);
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
