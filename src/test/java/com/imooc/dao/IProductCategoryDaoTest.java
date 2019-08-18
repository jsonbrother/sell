package com.imooc.dao;

import com.imooc.dao.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * Created by TongHaiJun
 * 2019/7/28 22:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IProductCategoryDaoTest {
    
    @Autowired
    private IProductCategoryDao iProductCategoryDao;
    
    @Test
    public void findOneTest(){
        ProductCategory productCategory = iProductCategoryDao.findById(1).orElse(null);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("新品榜",4);
        ProductCategory result = iProductCategoryDao.save(productCategory);
        // 判断新增成功 返回不等于空
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<ProductCategory> result = iProductCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result);
    }
}