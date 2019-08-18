package com.imooc.dao;


import com.imooc.dao.po.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IOrderDetailDaoTest {

    @Autowired
    private IOrderDetailDao iOrderDetailDao;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567");
        orderDetail.setOrderId("1234567");
        orderDetail.setProductId("1234567");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(1.2));
        orderDetail.setProductQuantity(3);
        orderDetail.setProductIcon("http://xxx.jpa");
        OrderDetail result = iOrderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderIdTest() {
        List<OrderDetail> orderDetailList = iOrderDetailDao.findByOrderId("1566071689891349645");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}