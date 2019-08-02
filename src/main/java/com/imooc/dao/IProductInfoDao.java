package com.imooc.dao;

import com.imooc.dao.po.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by TongHaiJun
 * 2019/7/29 19:59
 */
public interface IProductInfoDao extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
