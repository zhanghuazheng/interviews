package com.huazheng.arry;

import java.util.Arrays;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.arry
 * @author:zhanghuazheng
 * @createTime:2021/1/5 10:43
 * @version:1.0
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int a[][] = {{2,11},{2},{21,12,3232}};
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }
}
