package com.huazheng.net.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author: zhanghzi
 * @Email: zhanghzi@dcits.com
 * @Date: 2021/1/7 0:11
 * Description: TODO
 */
public class Sender implements Runnable {

    private int myPort;
    private int toPort;
    private String toHost;
    DatagramSocket client = null;
    BufferedReader bufferedReader = null;

    public Sender(int myPort, int toPort, String toHost) {
        this.myPort = myPort;
        this.toPort = toPort;
        this.toHost = toHost;
        try {
            client = new DatagramSocket(myPort);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        //组数据
        while (true) {
            try {
                String line = bufferedReader.readLine();
//                System.out.println(line);
                if ("Bye".equalsIgnoreCase(line)) {
                    break;
                }
                DatagramPacket packet = new DatagramPacket(line.getBytes(), 0, line.getBytes().length, new InetSocketAddress(this.toHost, this.toPort));
                //发送
                client.send(packet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        client.close();

    }
}
