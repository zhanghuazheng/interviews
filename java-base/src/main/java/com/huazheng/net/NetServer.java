package com.huazheng.net;

import jdk.nashorn.internal.ir.CallNode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @description: 服务端
 * @projectName:interviews
 * @see:com.huazheng.net
 * @author:zhanghuazheng
 * @createTime:2021/1/6 16:10
 * @version:1.0
 */
public class NetServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        ByteArrayOutputStream out = null;
        InputStream inputStream = null;
        Socket socket = null;
        serverSocket = new ServerSocket(9999);
        socket = serverSocket.accept();

        try {

//            while (true) {
//                accept = serverSocket.accept();
//                inputStream = accept.getInputStream();
//
//                out = new ByteArrayOutputStream();
//                byte[] bytes = new byte[1024];
//                int len;
//
//                while ((len = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, len);
//                    out.flush();
//                    System.out.println(out.toString());
//                }
//            }

            while (true){

                 inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len;
                StringBuilder str = new StringBuilder();
                while ((len=inputStream.read(bytes))!=-1){
                    str.append(new String(bytes,0,len));
                   break;
                }
                System.out.println(str.toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            socket.close();
            serverSocket.close();

        }


    }
}
