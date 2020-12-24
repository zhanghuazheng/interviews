package com.huazheng.service;

import com.huazheng.HelloDemo;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.service
 * @author:zhanghuazheng
 * @createTime:2020/12/24 15:39
 * @version:1.0
 */


public class HelloDemoService implements HelloDemo {
    @Override
    public void sayHello(String name) {
        System.out.println("provider服务sayhello:["+name+"]");
    }
}
