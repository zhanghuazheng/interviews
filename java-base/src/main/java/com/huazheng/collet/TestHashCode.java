package com.huazheng.collet;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.huazheng.entiy.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestHashCode {
    private List<Student> list = new ArrayList<>();

    @Before
    public void init(){
        Student zhz = new Student("zhz", ThreadLocalRandom.current().nextInt(100));
        Student zhq = new Student("zhq", ThreadLocalRandom.current().nextInt(100));
        Student zhw = new Student("zhw", ThreadLocalRandom.current().nextInt(100));
        Student zhe = new Student("zhe", ThreadLocalRandom.current().nextInt(100));
        Student zhr = new Student("zhr", ThreadLocalRandom.current().nextInt(100));

        list.add(zhz);
        list.add(zhq);
        list.add(zhw);
        list.add(zhe);
        list.add(zhr);
    }

    @Test
    public void testHash(){
        Student zhz = new Student("zhz", 30);
        Student chx = new Student("chx", 30);
        System.out.println(zhz.hashCode()==chx.hashCode());
        System.out.println(zhz.equals(chx));

    }

    /**
     * 测试hashcode相等，但是enquls不一定相等
     */
    @Test
    public void testHash2(){
       Integer aInt = 97;
       String aString = "a";
       String cString = "a";
        System.out.println(aInt.hashCode()==aString.hashCode());
        System.out.println(aString.equals(aInt));
        System.out.println("***********************");
        System.out.println(aString.hashCode()==cString.hashCode());
        System.out.println(cString.equals(aString));
    }

    /**
     * 不重写hashcode和enquls方法
     */
    @Test
    public void testHash3(){
        Student zhz = new Student("zhz", 21);
        Student chx = new Student("zhz", 21);
        System.out.println(zhz.equals(chx));
        System.out.println(zhz.hashCode()==chx.hashCode());
    }

    @Test
    public void testHash4(){
        for (Student student:list) {
            System.out.println(student);
        }
    }

    @Test
    public void testHash5(){
        ImmutableMap<String, Student> map = Maps.uniqueIndex(list, Student::getName);
        for (String s : map.keySet()) {
            System.out.println(s+":"+map.get(s));
        }
    }

    @Test
    public void testHash6(){
        String tranDate = "20201102";
        String startDate = "20201101";
        String endDate = "20201102";
        String optionType = "01";

        if("01".equals(optionType) &&(startDate != null && !"".equals(startDate)) && (tranDate !=null &&!"".equals(tranDate))){
            if(tranDate.compareTo(startDate)>0){
                System.out.println("开始日期小于了交易日期");

            }
        }


        if((endDate != null && !"".equals(endDate)) && (tranDate !=null &&!"".equals(tranDate))){
            if(tranDate.compareTo(endDate)>0){
                System.out.println("结束日期日期小于了交易日期");

            }
        }
    }
}
