package com.imooc.dao;

import com.imooc.dao.po.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TongHaiJun
 * 2019/8/15 21:14
 */
public interface ISellerInfoDao extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
