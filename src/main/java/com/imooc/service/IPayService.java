package com.imooc.service;

import com.imooc.service.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * Created by TongHaiJun
 * 2019/8/4 22:07
 */
public interface IPayService {

    /**
     * 微信H5支付
     * @param orderDTO
     * @return
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 微信异步通知
     * @param notifyData
     * @return
     */
    PayResponse notify(String notifyData);
}
