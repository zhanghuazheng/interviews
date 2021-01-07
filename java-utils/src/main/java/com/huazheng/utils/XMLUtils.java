package com.huazheng.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @description:
 * @projectName:interviews
 * @see:com.huazheng.utils
 * @author:zhanghuazheng
 * @createTime:2021/1/7 14:43
 * @version:1.0
 */
public class XMLUtils {
    /**
     * @param obj   要转换的对象引用(xxx)
     * @param clazz 要转换的对象类型(xxx.class)
     * @return 将Java对象转成XML字符串
     */
    public String beanToXml(Object obj, Class<?> clazz) throws JAXBException {
        StringWriter writer = new StringWriter();
        Marshaller marshaller = JAXBContext.newInstance(clazz).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(obj, writer);
        return writer.toString().replace("standalone=\"yes\"", "");
    }

    /**
     * @param xmlStr XML的String
     * @param clazz  要转换成的对象类型
     * @return 将XML的字符串(String)转换成对象(Object)
     */
    public Object xmlToBean(String xmlStr, Class<?> clazz) throws Exception {
        StringReader sr = new StringReader(xmlStr);
        return JAXBContext.newInstance(clazz).createUnmarshaller().unmarshal(sr);
    }

    /**
     * @param xmlFile XML文件对象
     * @param clazz   Java对象类型
     * @return 将XML文件数据反序列化为Java对象。
     * Notice : 该文件对象的属性必须和Java对象类型的属性一一对应
     */
    public Object xmlFileToBean(File xmlFile, Class clazz) throws JAXBException {
        return JAXBContext.newInstance(clazz).createUnmarshaller().unmarshal(xmlFile);
    }
}
