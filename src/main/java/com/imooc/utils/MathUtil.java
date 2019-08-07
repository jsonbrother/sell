package com.imooc.utils;

/**
 * Created by TongHaiJun
 * 2019/8/6 22:32
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较2个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        // 相减误差 以0.01做判断
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
