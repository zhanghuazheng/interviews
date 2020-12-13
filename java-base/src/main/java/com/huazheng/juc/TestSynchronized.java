package com.huazheng.juc;

import java.util.concurrent.ThreadLocalRandom;

public class TestSynchronized {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int m = ThreadLocalRandom.current().nextInt(3);
            System.out.println(m);
        }

    }
}
