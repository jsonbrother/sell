package com.imooc.dao;

import com.imooc.dao.po.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by TongHaiJun
 * 2019/7/31 22:51
 */
public interface IOrderDetailDao extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);

}
