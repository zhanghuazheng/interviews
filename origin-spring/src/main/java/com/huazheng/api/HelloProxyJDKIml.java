package com.huazheng.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 基于JDk的动态代理
 */
public class HelloProxyJDKIml implements InvocationHandler {
    Object target;

    public HelloProxyJDKIml(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理方法执行前");
        Object result = method.invoke(target, args);
        System.out.println("动态代理方法执行后");
        return result;
    }
}
