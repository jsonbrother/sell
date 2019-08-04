package com.imooc.service;

import com.imooc.service.dto.OrderDTO;

/**
 * Created by TongHaiJun
 * 2019/8/4 22:07
 */
public interface IPayService {

    void create(OrderDTO orderDTO);
}
