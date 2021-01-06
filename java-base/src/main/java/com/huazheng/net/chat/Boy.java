package com.huazheng.net.chat;

/**
 * @author: zhanghzi
 * @Email: zhanghzi@dcits.com
 * @Date: 2021/1/7 0:35
 * Description: TODO
 */
public class Boy {
    public static void main(String[] args) {
        new Thread(new Sender(9400,9300,"localhost")).start();
        new Thread(new Reciver("girl",9200)).start();
    }
}
