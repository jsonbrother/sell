package com.imooc.dao;


import com.imooc.dao.po.SellerInfo;
import com.imooc.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by TongHaiJun
 * 2019/8/15 21:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ISellerInfoDaoTest {

    @Autowired
    private ISellerInfoDao iSellerInfoDao;

    private static final String OPEN_ID = "oTgZpwYNL23UwFOXNMEOx5ugIkY8";

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("Json");
        sellerInfo.setPassword("88888");
        sellerInfo.setOpenid(OPEN_ID);
        SellerInfo result = iSellerInfoDao.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenid(){
        SellerInfo sellerInfo = iSellerInfoDao.findByOpenid(OPEN_ID);
        System.out.println(sellerInfo.toString());
    }

}