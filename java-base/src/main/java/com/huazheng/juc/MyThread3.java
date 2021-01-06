package com.huazheng.juc;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/6 10:41
 * @version:1.0
 */
public class MyThread3 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread extend Thread");
    }
}
