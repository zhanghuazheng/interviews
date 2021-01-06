package com.huazheng.net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description: 客户端
 * @projectName:interviews
 * @see:com.huazheng.net
 * @author:zhanghuazheng
 * @createTime:2021/1/6 16:07
 * @version:1.0
 */
public class NetClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream out = null;
        try {
            socket = new Socket("localhost", 9999);
            String msg = "你好啊";

            while (true) {
                out = socket.getOutputStream();
                Thread.sleep(1000);
                out.write(msg.getBytes());
                out.flush();

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
