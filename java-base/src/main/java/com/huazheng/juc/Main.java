package com.huazheng.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/6 10:06
 * @version:1.0
 */
public class Main {
    public static void main(String[] args) {

        //测试callable接口的线程
        FutureTask<Boolean> task = new FutureTask<>(new MyThread());
        new Thread(task).start();
        try {
            Boolean result = task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("------------------测试Runnable接口对应的线程---------------");

        //测试Runnable接口对应的线程
        new Thread(new MyThread2()).start();

        System.out.println("----------------测试继承Thread类对应的线程------------------");

        //测试继承Thread类对应的线程
        new MyThread3().start();

    }
}
