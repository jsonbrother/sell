package com.imooc.service;

import com.imooc.service.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * Created by TongHaiJun
 * 2019/8/4 22:07
 */
public interface IPayService {

    PayResponse create(OrderDTO orderDTO);
}
