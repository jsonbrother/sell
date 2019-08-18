package com.imooc.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * Created by TongHaiJun
 * 2019/7/29 20:57
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 8388223064373192755L;

    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体内容.
     */
    private T data;
}
