package com.imooc.controller;

import com.imooc.dao.po.ProductInfo;
import com.imooc.exception.SellException;
import com.imooc.service.IProductService;
import lombok.extern.slf4j.Slf4j;
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
 * Created by TongHaiJun
 * 2019/8/13 23:28
 */
@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private IProductService iProductService;

    /**
     * 商品列表.
     * @param page 第几页，从1页开始
     * @param size 一页有多少条数据
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        PageRequest pageable = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = iProductService.findAll(pageable);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("/product/list", map);
    }

    /**
     * 商品上架
     * @param productId 商品编号
     * @return
     */
    @GetMapping("/onSale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            iProductService.onSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 商品下架
     * @param productId 商品编号
     * @return
     */
    @GetMapping("/offSale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            iProductService.offSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
