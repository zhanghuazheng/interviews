package com.huazheng.juc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: zhanghzi
 * @Email: zhanghzi@dcits.com
 * @Date: 2021/1/6 23:39
 * Description: TODO
 */
public class TestUrl {
    public static void main(String[] args) {
        FileOutputStream outputStream=null;
        InputStream inputStream =null;
        URLConnection connection =null;
        try {
            URL url = new URL("https://p3fx.kgimg.com/v2/fxroomcover/9a0965cd7715121ded9d90c0edbe17c4.jpg_200x200.jpg");
             connection = url.openConnection();
             inputStream = connection.getInputStream();
             outputStream = new FileOutputStream("a.jpg");
            byte[] bytes = new byte[1024];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
