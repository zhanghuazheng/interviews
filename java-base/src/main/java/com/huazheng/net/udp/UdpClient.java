package com.huazheng.net.udp;

import java.net.*;

/**
 * @author: zhanghzi
 * @Email: zhanghzi@dcits.com
 * @Date: 2021/1/6 23:53
 * Description: TODO
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
        //申明一个端口
        DatagramSocket client = new DatagramSocket(8100);

        InetAddress localhost = InetAddress.getByName("localhost");
        String msg = "UDP 发送消息";
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, 8200);
        //发送
        client.send(packet);

        client.close();



    }
}
