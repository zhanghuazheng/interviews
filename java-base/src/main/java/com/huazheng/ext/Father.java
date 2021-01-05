package com.huazheng.ext;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.ext
 * @author:zhanghuazheng
 * @createTime:2021/1/4 12:19
 * @version:1.0
 */
public class Father {
    {
        System.out.println("Father 代码块");
    }
    static {
        System.out.println("Father 静态代码块");
    }
    public Father(){
        System.out.println("Father 构造器");
    }
}
