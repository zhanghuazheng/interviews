package com.huazheng.api;

/**
 * 静态代理类
 */
public class HelloProxyImpl implements HelloAPI{
    private HelloAPI helloAPI;

    public HelloProxyImpl(HelloAPI helloAPI){
        this.helloAPI = helloAPI;
    }
    @Override
    public void sayHello() {
        System.out.println("静态代理处理before");
        helloAPI.sayHello();
        System.out.println("静态代理处理after");
    }
}
