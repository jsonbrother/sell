package com.imooc.service;

import com.imooc.service.dto.OrderDTO;

/**
 * 微信推送信息
 * Created by TongHaiJun
 * 2019/8/18 2:00
 */
public interface IPushMessageService {

    /**
     * 订单状态变更信息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
