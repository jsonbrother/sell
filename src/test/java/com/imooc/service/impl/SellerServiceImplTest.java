package com.imooc.service.impl;

import com.imooc.dao.po.SellerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    @Autowired
    private SellerServiceImpl sellerService;

    private static final String OPEN_ID = "oTgZpwYNL23UwFOXNMEOx5ugIkY8";

    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo result = sellerService.findSellerInfoByOpenid(OPEN_ID);
        System.out.println(result.toString());
    }
}