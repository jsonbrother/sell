package com.imooc.dao.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by TongHaiJun
 * 2019/8/15 21:12
 */
@Data
@Entity
@Table(name = "tb_seller_info")
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

}
