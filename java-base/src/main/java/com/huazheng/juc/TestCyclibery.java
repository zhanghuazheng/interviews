package com.huazheng.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/8 10:43
 * @version:1.0
 */
public class TestCyclibery {

    public static void main(String[] args) throws Exception {
        FutureTask<Integer> task = new FutureTask<>(new SumThread());
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "开始准备");
//                    new Thread(task, Thread.currentThread().getName()).start();
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "执行完毕");

                    new Thread(task, "my").start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }, "A");

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "开始准备");
//                    new Thread(task, Thread.currentThread().getName()).start();
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "执行完毕");

                    new Thread(task, "my").start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }, "B");

        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "开始准备");
//                    new Thread(task, Thread.currentThread().getName()).start();
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "执行完毕");

                    new Thread(task, "my").start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }, "C");

        A.start();

        B.start();

        C.start();


}
}
