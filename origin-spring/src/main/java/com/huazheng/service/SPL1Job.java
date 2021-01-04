package com.huazheng.service;

import com.huazheng.abstrac.AbstractJobProcess;
import org.springframework.stereotype.Service;

import javax.swing.table.AbstractTableModel;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.service
 * @author:zhanghuazheng
 * @createTime:2020/12/31 15:58
 * @version:1.0
 */

@Service
public class SPL1Job extends AbstractJobProcess {
    public void writeFile(){
        System.out.println("SPL1Job writeFile");
    }

    @Override
    public void readFile() {
        System.out.println("SPL1Job readFile");
    }
}
