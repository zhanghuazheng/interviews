package com.huazheng.test;

import com.huazheng.entiy.Student;
import org.junit.Test;

public class TestHashCode {
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
}
