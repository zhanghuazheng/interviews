package com.huazheng.test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MainCompare {
    public static void main(String[] args) {
        String amt = "12345678901234567890";
        int i = new BigDecimal("0").compareTo(new BigDecimal(amt));
        if(i>=0){
            System.out.println("金额小于等于0");
        }else {
            System.out.println("金额大于0");
        }
    }
}
