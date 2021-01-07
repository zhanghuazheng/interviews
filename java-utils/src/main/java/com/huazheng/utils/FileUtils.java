package com.huazheng.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.utils
 * @author:zhanghuazheng
 * @createTime:2021/1/7 14:42
 * @version:1.0
 */
public class FileUtils {


    /**
     * @param name 文件名
     * @return 校验文件名是否为图片格式
     */
    public static boolean checkFileNameIsImage(String name) {
        String reg = ".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(name.toLowerCase());
        return matcher.find();
    }

    /**
     * @param multipartFile 文件
     * @return 校验文件是否为图片格式     //过滤非jpg,png格式的文件
     */
    public boolean checkFileIsImage(MultipartFile multipartFile) {

        return (multipartFile.getContentType().equalsIgnoreCase("image/jpg")
                || multipartFile.getContentType().equalsIgnoreCase("image/jpeg")
                || multipartFile.getContentType().equalsIgnoreCase("image/png")
                || multipartFile.getContentType().equalsIgnoreCase("image/gif")
        );
    }


    /**
     * @param zipFile     待解压的zip文件
     * @param descDir     指定目录
     * @param filePreName 文件的前缀名称
     *                    解压文件到指定目录 解压后的文件名,和之前一致
     */
    @SuppressWarnings("rawtypes")
    public static void unZipFiles(File zipFile, String descDir, String filePreName) throws IOException {
        java.util.zip.ZipFile zip = new java.util.zip.ZipFile(zipFile, Charset.forName("GBK"));   // 解决中文文件夹乱码
        File pathFile = new File(descDir);
        if (!pathFile.exists()) pathFile.mkdirs();
        for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = entries.nextElement();
            String zipEntryName = filePreName + "_" + entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir + "/" + zipEntryName).replaceAll("\\*", "/");
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/'))); // 判断路径是否存在,不存在则创建文件路径
            if (!file.exists()) file.mkdirs(); // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            File outPathFile = new File(outPath);
            if (outPathFile.isDirectory()) continue;
            FileOutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
    }

    /**
     * @param inStream 字节流
     * @return 得到字节流 数组大小
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * @param filePath 文件路径
     * @return 将文件对象转换成字节数组
     */
    public static byte[] File2Byte(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * @param urlPath     文件地址
     * @param downloadDir 下载目录
     * @param filename    保存文件名
     * @return 通过url下载文件
     */
    public static File downloadFile(String urlPath, String downloadDir, String filename) {
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(3 * 1000); // 设置超时间为3秒
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream inputStream = conn.getInputStream();   // 得到输入流
            byte[] getData = readStream(inputStream);  // 获取数组
            File saveDir = new File(downloadDir);   // 文件保存位置
            if (!saveDir.exists()) saveDir.mkdir();
            File file = new File(saveDir + File.separator + filename);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            fos.close();
            if (inputStream != null) inputStream.close();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将InputStream写入本地文件
     *
     * @param destination 写入本地文件全路径名
     * @param input       输入流
     */
    private static void writeToLocalFile(String destination, InputStream input) throws IOException {
        int index;
        byte[] bytes = new byte[1024];
        File outFile = new File(destination);
        if (!outFile.getParentFile().exists()) outFile.getParentFile().mkdirs();
        try (FileOutputStream fos = new FileOutputStream(destination)) {
            while ((index = input.read(bytes)) != -1) {
                fos.write(bytes, 0, index);
                fos.flush();
            }
        }
        input.close();
    }

    /**
     * @param fileName 传入文件全名
     * @return 删除单个文件
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);  // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        return file.exists() && file.isFile() && file.delete();
    }

    /**
     * @param dir 要删除的目录的文件路径
     * @return 删除目录及目录下的文件, 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        if (!dir.endsWith(File.separator)) dir = dir + File.separator;    // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        File dirFile = new File(dir);
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) return false; // 如果dir对应的文件不存在，或者不是一个目录，则退出
        boolean result = true;
        File[] files = dirFile.listFiles();  // 删除文件夹中的所有文件包括子目录
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {   // 删除子文件
                    result = deleteFile(file.getAbsolutePath());
                    if (!result) break;
                } else if (file.isDirectory()) {   // 删除子目录
                    result = deleteDirectory(file.getAbsolutePath());
                    if (!result) break;
                }
            }
        }
        // 删除当前目录
        return result && dirFile.delete();
    }

}
