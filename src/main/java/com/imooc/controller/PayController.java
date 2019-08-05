package com.imooc.controller;

import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.IOrderService;
import com.imooc.service.IPayService;
import com.imooc.service.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by TongHaiJun
 * 2019/8/4 22:04
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IPayService iPayService;

    @GetMapping("/create")
    @Transactional
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        //1.查询订单
        OrderDTO orderDTO = iOrderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2.发起支付
        PayResponse payResponse = iPayService.create(orderDTO);
        map.put("payResponse",payResponse);

        return new ModelAndView("pay/create", map);
    }
}
