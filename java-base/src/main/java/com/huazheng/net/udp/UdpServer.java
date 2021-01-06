package com.huazheng.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author: zhanghzi
 * @Email: zhanghzi@dcits.com
 * @Date: 2021/1/6 23:53
 * Description: TODO
 */
public class UdpServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(8200);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        //接收
        server.receive(packet);

        byte[] data = packet.getData();
        String s = new String(data, 0, data.length);
        System.out.println(s);
        server.close();

    }
}
