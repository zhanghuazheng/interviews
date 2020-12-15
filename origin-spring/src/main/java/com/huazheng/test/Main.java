package com.huazheng.test;

import com.huazheng.api.HelloAPI;
import com.huazheng.api.HelloProxyImpl;
import com.huazheng.api.HelloStaticImpl;

public class Main {
    public static void main(String[] args) {

        HelloAPI hello = new HelloProxyImpl(new HelloStaticImpl());
        hello.sayHello();

    }
}
