package com.huazheng.net.chat;

/**
 * @author: zhanghzi
 * @Email: zhanghzi@dcits.com
 * @Date: 2021/1/7 0:37
 * Description: TODO
 */
public class Girl {
    public static void main(String[] args) {
        new Thread(new Sender(9100,9200,"localhost")).start();
        new Thread(new Reciver("boy",9300)).start();
    }
}
