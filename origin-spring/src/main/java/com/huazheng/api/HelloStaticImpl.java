package com.huazheng.api;

/**
 * 静态实现类
 */
public class HelloStaticImpl implements HelloAPI {

    @Override
    public void sayHello() {
        System.out.println("普通的实现类");
    }
}
