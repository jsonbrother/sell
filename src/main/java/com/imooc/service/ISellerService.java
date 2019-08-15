package com.imooc.service;

import com.imooc.dao.po.SellerInfo;

/**
 * 卖家端.
 * Created by TongHaiJun
 * 2019/8/15 21:24
 */
public interface ISellerService {

    /**
     * 通过openid查询卖家信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);

}
