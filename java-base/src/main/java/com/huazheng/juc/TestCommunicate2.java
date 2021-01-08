package com.huazheng.juc;

/**
 * @description: 测试线程通信的wait() 和notify()
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/8 10:07
 * @version:1.0
 */
public class TestCommunicate2 {
    private  static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock){
                        Thread.sleep(1000);
                        System.out.println("A -->A1");
                        lock.wait();
                        System.out.println("A -->A2");
                        System.out.println("A -->A3");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A");

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock){
                        print(Thread.currentThread().getName());
                        lock.notify();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B");

        System.out.println("main 线程开始执行");
        A.start();
        B.start();
    }

    public static int sum(int num){
        int sum=0;
        for (int i = 0; i < num; i++) {
            sum=sum+i;
        }
        return sum;
    }

    public static void print(String name){
        char[] letter = {'A','B','C'};
        for (int i = 0; i < letter.length; i++) {
            System.out.println(name+"线程打印："+letter[i]);
        }
    }
}
