package com.huazheng;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng
 * @author:zhanghuazheng
 * @createTime:2020/12/24 15:36
 * @version:1.0
 */
public class ConsumerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
        HelloDemo helloDemo = (HelloDemo)context.getBean("helloDemo");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            helloDemo.sayHello("zhz"+i);
        }
    }
}
