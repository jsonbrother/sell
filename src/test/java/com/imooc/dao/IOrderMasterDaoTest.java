package com.imooc.dao;


import com.imooc.dao.po.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IOrderMasterDaoTest {

    @Autowired
    private IOrderMasterDao iOrderMasterDao;

    private static final String OPENID = "Json666";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("Json");
        orderMaster.setBuyerPhone("17800000001");
        orderMaster.setBuyerAddress("上海");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster result = iOrderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenidTest(){
        PageRequest request = PageRequest.of(1,3);
        Page<OrderMaster> result = iOrderMasterDao.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}