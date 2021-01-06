package com.huazheng.net;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1",9898);
        int reqCount =0;
        while(true) {
            socket.getOutputStream().write(("请求时间第"+reqCount+++"次over").getBytes("UTF-8"));
            socket.getOutputStream().flush();

            //流模式下只要不关闭，就可以反复持有，获取数据。  输入流还是那个。
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            //一次交互完成后，while循环过来，在此阻塞，即监听
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
                //单次交互结束标识，跳出监听
                if(new String(bytes, 0, len).indexOf("over")>=0){
                    break;
                }
            }
            System.out.println("服务端返回的消息: " +  sb.toString().substring(0,sb.toString().length()-4));
            Thread.sleep(2000);
        }
    }
}