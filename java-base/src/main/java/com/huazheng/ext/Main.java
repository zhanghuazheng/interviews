package com.huazheng.ext;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.ext
 * @author:zhanghuazheng
 * @createTime:2021/1/4 12:20
 * @version:1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main 主类");

        new Son();
        System.out.println("-----------------------------");


        new Father();
        System.out.println("-----------------------------");

        new Son();
        System.out.println("-----------------------------");

    }
}
