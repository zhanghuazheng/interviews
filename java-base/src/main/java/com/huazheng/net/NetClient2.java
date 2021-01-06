package com.huazheng.net;

import java.io.IOException;
import java.net.Socket;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.net
 * @author:zhanghuazheng
 * @createTime:2021/1/6 18:13
 * @version:1.0
 */
public class NetClient2 {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        socket = new Socket("localhost", 9898);
        int reqCount =0;
        for (int i = 0; i < 10; i++) {
            socket.getOutputStream().write(("请求时间第"+i+"次over").getBytes("UTF-8"));
            socket.getOutputStream().flush();
            Thread.sleep(1000);
        }



    }
}
