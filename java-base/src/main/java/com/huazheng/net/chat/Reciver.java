package com.huazheng.net.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author: zhanghzi
 * @Email: zhanghzi@dcits.com
 * @Date: 2021/1/7 0:11
 * Description: TODO
 */
public class Reciver implements Runnable {
    private String name;
    private int myPort;
    DatagramSocket socket = null;

    public Reciver(String name, int myPort) {
        this.name = name;
        this.myPort = myPort;
        try {
            socket = new DatagramSocket(myPort);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while (true) {
            try {
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
                socket.receive(packet);
                byte[] data = packet.getData();
                String recive = new String(data, 0, data.length);
                if ("Bye".equalsIgnoreCase(recive)) {
                    break;
                }
                System.out.println(name + ":" + recive);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        socket.close();

    }
}
