package com.imooc.service;

import com.imooc.service.dto.OrderDTO;

/**
 * Created by TongHaiJun
 * 2019/8/2 23:06
 */
public interface IBuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
