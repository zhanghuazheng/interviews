package com.huazheng.juc;

/**
 * @description: 测试守护线程与用户线程
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/6 20:09
 * @version:1.0
 */
public class TestDameoThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

//        thread.setDaemon(true);
        thread.start();

        System.out.println("main 线程");
    }
}
