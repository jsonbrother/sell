package com.imooc.utils;

import com.imooc.controller.vo.ResultVO;

/**
 * Created by TongHaiJun
 * 2019/7/29 21:35
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }

}
