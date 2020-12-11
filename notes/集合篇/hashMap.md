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



# 二、hashMap的底层数据结构

首先需要划分jdk版本的问题，对于1.7和1.8是不同的

- 1.7

  底层主要是数组和链表

- 1.8

  底层是数组和链表、在一定条件下会转化成红黑树

说明：假设存储一个数据，map中是使用put()方法存储，首先会对key进行一系列的hash运算，取模运算，最终计算出这个数据在数组中的位置索引，然后根据当前数据进行判断是否需要进行扩容，是否需要转化成红黑树，是否重复进行替换旧数据，同理获取数据也是如此

# 三、jdk1.8对hash算法和寻址算法的优化

## 1.对key进行hash

```java
 static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
```

异或运算，一样为0，不一样为1，这样异或运算后，高低16位都会参与运算

## 2.优化点

首先没有对数组的长度进行取模运算，而是采用了先进性异或运算获取到hash值，然后通过与运算与数组长度减1，即（hash&(n-1)）计算在数组中的位置，虽然计算方式不一样，但是效果一样，特别是位运算在性能上优于取模运算。

## 3.总结

hash的优化：对每一个key首先进行了hash,然后让低16位与高16位进行了异或运算，使低16位保留了高低16位的特征，尽可能的避免了后续的hash冲突。

寻址的优化：用与运算代替了取模运算，提高了性能

# 四、hashmap如何解决hash冲突

首先在对key进行hash运算，寻址运算，最后获取到他在数组中的位置，如果发现在数组对应的位置则此时存在数据，则会在该位置下生成一个链表来存储数据，如果这个链表的长度达到一定的长度则会转化成红黑数，比如获取一个数据的时候，时间复杂度就会由原来的O(n)变为o(logn)

# 五、hashMap扩容的问题

当hashMap的数组长度达到一定长度后，需要进行扩容，首先需要对原来的数据hash进行rehash,为了避免更多的rehash，首先会让hash与扩容后的长度（n-1）进行index，如果没有位置没有变则寻址结果还是原来，如果index发生变化后，则去检查是否多了一位，如果是则newindex=oldIndex+oldCap,这样可以避免rehash