package com.huazheng.juc;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/6 20:21
 * @version:1.0
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("ThreadA");
                System.out.println("线程A before："+threadLocal.get());
                threadLocal.remove();
                System.out.println("线程A after："+threadLocal.get());

            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                    threadLocal.set("ThreadB");
                System.out.println("线程A before："+threadLocal.get());
                System.out.println("线程A after："+threadLocal.get());

            }
        },"B").start();

    }
}
