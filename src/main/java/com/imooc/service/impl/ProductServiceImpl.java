package com.imooc.service.impl;

import com.imooc.dao.IProductInfoDao;
import com.imooc.dao.po.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.IProductService;
import com.imooc.service.dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by TongHaiJun
 * 2019/7/29 20:20
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductInfoDao iProductInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return iProductInfoDao.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return iProductInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return iProductInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return iProductInfoDao.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = iProductInfoDao.findById(cartDTO.getProductId()).orElse(null);
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            iProductInfoDao.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = iProductInfoDao.findById(cartDTO.getProductId()).orElse(null);
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            iProductInfoDao.save(productInfo);
        }
    }

    @Override
    @Transactional
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = iProductInfoDao.findById(productId).orElse(null);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        // 1.判断商品状态是否在架
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        // 2.更新商品状态
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return iProductInfoDao.save(productInfo);
    }

    @Override
    @Transactional
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = iProductInfoDao.findById(productId).orElse(null);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        // 1.判断商品状态是否下架
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        // 2.更新商品状态
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return iProductInfoDao.save(productInfo);
    }
}
