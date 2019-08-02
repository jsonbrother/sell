package com.imooc.controller;

import com.imooc.controller.form.OrderForm;
import com.imooc.controller.vo.ResultVO;
import com.imooc.converter.orderForm2OrderDTOConverter;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.IOrderService;
import com.imooc.service.dto.OrderDTO;
import com.imooc.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TongHaiJun
 * 2019/8/1 22:34
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private IOrderService iOrderService;

    // 创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = orderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空，");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult =  iOrderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    // 订单列表

    // 订单详情

    // 取消订单
}
