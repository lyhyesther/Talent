package com.ly.utillibrary;

import java.math.BigDecimal;

public class PriceUtil {
    /**
     * 加法
     */
    public static BigDecimal add(BigDecimal origin, BigDecimal add) {
        return origin.add(add);
    }

    /**
     * 减法
     */
    public static BigDecimal substract(BigDecimal origin, BigDecimal substract) {
        return origin.subtract(substract);
    }

    /**
     * 乘法
     */
    public static BigDecimal multiply(BigDecimal origin, BigDecimal multiply) {
        return origin.multiply(multiply);
    }

    /**
     * 除法
     */
    public static BigDecimal divide(BigDecimal origin, BigDecimal divide) {
        return origin.divide(divide).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 绝对值
     */
    public static BigDecimal abs(BigDecimal origin) {
        return origin.abs();
    }
}
