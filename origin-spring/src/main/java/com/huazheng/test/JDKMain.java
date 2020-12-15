package com.huazheng.test;

import com.huazheng.api.HelloAPI;
import com.huazheng.api.HelloProxyJDKIml;
import com.huazheng.api.HelloStaticImpl;

import java.lang.reflect.Proxy;

public class JDKMain {
    public static void main(String[] args) {
        HelloStaticImpl helloAPI = new HelloStaticImpl();
        HelloProxyJDKIml jdkIml = new HelloProxyJDKIml(helloAPI);

        HelloAPI helloHandle =(HelloAPI) Proxy.newProxyInstance(HelloStaticImpl.class.getClassLoader(), new Class[]{HelloAPI.class}, jdkIml);
        helloHandle.sayHello();
    }
}
