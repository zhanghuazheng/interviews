package com.huazheng.juc;

/**
 * @description: 测试线程通信的join()
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/8 10:07
 * @version:1.0
 */
public class TestCommunicate {

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    print(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A");

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //虽然A线程增加了延迟，但是B线程也不会先执行，他需要等待A线程执行完毕后才会再执行
                    A.join();
                    print(Thread.currentThread().getName());
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
