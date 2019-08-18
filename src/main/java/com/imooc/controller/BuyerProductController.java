package com.imooc.controller;

import com.imooc.controller.vo.ProductInfoVO;
import com.imooc.controller.vo.ProductVO;
import com.imooc.controller.vo.ResultVO;
import com.imooc.dao.po.ProductCategory;
import com.imooc.dao.po.ProductInfo;
import com.imooc.service.ICategoryService;
import com.imooc.service.IProductService;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by TongHaiJun
 * 2019/7/29 20:51
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product", key = "123")
    public ResultVO list() {
        // 1.查询所有上架商品
        List<ProductInfo> productInfoList = iProductService.findUpAll();

        // 2.查询类目（一次性查询）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = iCategoryService.findByCategoryTypeIn(categoryTypeList);

        // 3.数据拼装
        List<ProductVO> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVo = new ProductVO();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVo = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        return ResultVOUtil.success(productVoList);
    }
}
