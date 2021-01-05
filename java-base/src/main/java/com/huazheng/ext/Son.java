package com.huazheng.ext;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.ext
 * @author:zhanghuazheng
 * @createTime:2021/1/4 12:20
 * @version:1.0
 */
public class Son extends Father{
    {
        System.out.println("Son 代码块");
    }
    static {
        System.out.println("Son 静态代码块");
    }
    public Son(){
        System.out.println("Son 构造器");
    }
}
