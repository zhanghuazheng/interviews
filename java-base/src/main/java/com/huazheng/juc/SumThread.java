package com.huazheng.juc;

import java.util.concurrent.Callable;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/8 10:54
 * @version:1.0
 */
public class SumThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"线程开始计算数据");
        Thread.sleep(1000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
             sum=sum+i;
        }
        System.out.println(Thread.currentThread().getName()+"线程计算结果sum="+sum);
        return sum;
    }
}
