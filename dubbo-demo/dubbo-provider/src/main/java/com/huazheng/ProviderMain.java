package com.huazheng;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng
 * @author:zhanghuazheng
 * @createTime:2020/12/24 15:42
 * @version:1.0
 */
public class ProviderMain {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/dubbo-provider.xml");
        context.start();
        System.in.read();
    }
}
