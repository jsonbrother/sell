package com.imooc.controller;

import com.imooc.controller.form.ProductForm;
import com.imooc.dao.po.ProductCategory;
import com.imooc.dao.po.ProductInfo;
import com.imooc.exception.SellException;
import com.imooc.service.ICategoryService;
import com.imooc.service.IProductService;
import com.imooc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
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

    @Autowired
    private ICategoryService iCategoryService;

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
        PageRequest pageable = PageRequest.of(page - 1, size);
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
    @CacheEvict(cacheNames = "product", key = "123")
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
    @CacheEvict(cacheNames = "product", key = "123")
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

    /**
     * 商品表单界面
     * @param productId 商品编号
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = iProductService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        List<ProductCategory> productCategoryList = iCategoryService.findAll();
        map.put("productCategoryList", productCategoryList);

        return new ModelAndView("product/index", map);
    }

    /**
     * 商品新增/修改
     * @param productForm form数据
     * @param bindingResult 验证信息
     * @return
     */
    @PostMapping("/save")
    @CacheEvict(cacheNames = "product", key = "123")
    public ModelAndView save(@Valid ProductForm productForm,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            // 判断productId是否为空 true=新增，false=修改
            if(!StringUtils.isEmpty(productForm.getProductId())){
                productInfo = iProductService.findOne(productForm.getProductId());
            } else{
                productForm.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(productForm, productInfo);
            iProductService.save(productInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
