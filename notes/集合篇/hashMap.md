# 一、hashCode和enquls的区别？

hashCode是native修饰的方法，返回的是对象的地址

enquls若是比较的基本数据类型，则是比较的他们的值是否相等，若是比较的引用类型变量则是比较的他们的物理地址是否相等。

```java
 public void testHash2(){
       Integer aInt = 97;
       String aString = "a";
        System.out.println(aInt.hashCode()==aString.hashCode());
        System.out.println(aString.equals(aInt));
    }
```



测试结果：

![image-20201211165103152](E:\projects\myProjects\interviews\notes\集合篇\hashMap.assets\image-20201211165103152.png)



# 一、hashMap的底层数据结构

