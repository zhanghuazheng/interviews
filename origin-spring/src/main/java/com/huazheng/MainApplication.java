package com.huazheng;

import com.huazheng.abstrac.AbstractJobProcess;
import com.huazheng.service.SPL3Job;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng
 * @author:zhanghuazheng
 * @createTime:2020/12/31 16:16
 * @version:1.0
 */
public class MainApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        AbstractJobProcess sPL1Job = context.getBean("SPL3Job", SPL3Job.class);
        sPL1Job.excute();


    }
}
