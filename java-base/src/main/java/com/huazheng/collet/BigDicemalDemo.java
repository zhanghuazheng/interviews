package com.huazheng.collet;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.collet
 * @author:zhanghuazheng
 * @createTime:2021/1/5 17:00
 * @version:1.0
 */


public class BigDicemalDemo {
    @Test
    public void testDivide(){
        BigDecimal origLoanAmt = new BigDecimal("100");
        origLoanAmt = origLoanAmt.divide(new BigDecimal(9),2,BigDecimal.ROUND_HALF_UP);
        System.out.println(origLoanAmt);

    }
}
