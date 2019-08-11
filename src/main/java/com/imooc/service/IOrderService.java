package com.imooc.service;

import com.imooc.service.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by TongHaiJun
 * 2019/7/31 23:26
 */
public interface IOrderService {

    /**
     * 创建订单.
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单.
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询单个列表.
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 查询所有列表.
     */
    Page<OrderDTO> findList(Pageable pageable);

    /**
     * 支付订单.
     */
    OrderDTO paid(OrderDTO orderDTO);

    /**
     * 完结订单.
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 取消订单.
     */
    OrderDTO cancel(OrderDTO orderDTO);
}
