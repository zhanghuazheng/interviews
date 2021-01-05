package com.huazheng.juc;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.juc
 * @author:zhanghuazheng
 * @createTime:2021/1/4 11:40
 * @version:1.0
 */
public class ExecutorDemo {
    static Timer timer = new Timer();
    public static void main(String[] args) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("taskone ... ...");
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("myRunTimeException");
            }
        },500);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("tasktwo ... ...");
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },1000);
    }
}
