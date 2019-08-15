package com.imooc.service.impl;

import com.imooc.dao.ISellerInfoDao;
import com.imooc.dao.po.SellerInfo;
import com.imooc.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by TongHaiJun
 * 2019/8/15 21:24
 */
@Service
public class SellerServiceImpl implements ISellerService {

    @Autowired
    private ISellerInfoDao iSellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return iSellerInfoDao.findByOpenid(openid);
    }
}
