package com.imooc.service.impl;

import com.imooc.service.IPayService;
import com.imooc.service.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PayServiceImplTest {

    @Autowired
    private PayServiceImpl payService;

    @Test
    public void create() {
        OrderDTO dto = new OrderDTO();
        payService.create(dto);
    }
}