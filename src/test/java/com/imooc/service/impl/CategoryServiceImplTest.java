package com.imooc.service.impl;

import com.imooc.dao.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("测试类目",5);
        categoryService.save(productCategory);
    }

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(Integer.valueOf(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList =  categoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> categoryTypeList = Arrays.asList(1,2,3,4);
        List<ProductCategory> result = categoryService.findByCategoryTypeIn(categoryTypeList);
        Assert.assertNotEquals(0,result);
    }
}