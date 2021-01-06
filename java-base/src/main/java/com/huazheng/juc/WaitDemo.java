package com.huazheng.juc;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/6 11:27
 * @version:1.0
 */
public class WaitDemo {
    private static volatile Object A = new Object();
    private static volatile Object B = new Object();

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("A线程获取共享资源A锁");
                    synchronized (A) {
                        System.out.println("A线程获取共享资源B锁");
                        synchronized (B) {
                            System.out.println("A线程释放共享资源B锁");
                            A.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("B线程获取共享资源A锁");
                    synchronized (A) {
                        System.out.println("B线程尝试获取共享资源B锁");
                        synchronized (B) {
                            System.out.println("B线程释放共享资源A锁");
                            A.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "B").start();
    }


}
