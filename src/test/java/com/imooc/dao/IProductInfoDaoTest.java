package com.imooc.dao;

import com.imooc.dao.po.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by TongHaiJun
 * 2019/7/29 20:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IProductInfoDaoTest {

    @Autowired
    private IProductInfoDao iProductInfoDao;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(BigDecimal.valueOf(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxx.jpa");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);
        ProductInfo result = iProductInfoDao.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatusTest() {
        List<ProductInfo> productInfos = iProductInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfos.size());
    }

}