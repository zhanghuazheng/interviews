package com.huazheng.abstrac;

import com.huazheng.api.IJobProcess;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.abstrac
 * @author:zhanghuazheng
 * @createTime:2020/12/31 15:58
 * @version:1.0
 */

@Service
public abstract class AbstractJobProcess implements IJobProcess {
    @Override
    public void excute() {
        readFile();

        writeFile();

        System.out.println("abstract excute");
    }

    /**
     * 写文件
     */
    public abstract void writeFile();

    /**
     * 读文件
     */
    public abstract void readFile();

}
