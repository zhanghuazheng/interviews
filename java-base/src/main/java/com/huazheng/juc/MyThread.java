package com.huazheng.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/6 10:04
 * @version:1.0
 */
public class MyThread implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println("MyThread Callable");
        return true;
    }
}
