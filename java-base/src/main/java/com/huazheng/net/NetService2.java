package com.huazheng.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.net
 * @author:zhanghuazheng
 * @createTime:2021/1/6 18:54
 * @version:1.0
 */
public class NetService2 {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = null;

        while (true) {
            inputStream = socket.getInputStream();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                stream.write(bytes, 0, len);
                stream.flush();
                break;
            }
            System.out.println(stream.toString());
        }

    }
}
