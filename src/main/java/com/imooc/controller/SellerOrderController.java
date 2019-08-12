package com.imooc.controller;

import com.imooc.service.IOrderService;
import com.imooc.service.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * 卖家订单列表
 * Created by TongHaiJun
 * 2019/8/12 22:32
 */
@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {

    @Autowired
    private IOrderService iOrderService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String, Object> map) {
        PageRequest pageable = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = iOrderService.findList(pageable);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("/order/list", map);
    }

}
