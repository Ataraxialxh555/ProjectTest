package Day7_18;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest01 {
    public static void main(String[] args) {
        Collection  c1 = new ArrayList();
        //add()方法
        c1.add(11);
        c1.add(22);
        c1.add('a');
        c1.add("lxh");
        c1.add(3.15f);
        c1.add(22222222L);
        // size()方法
        System.out.println("集合c1的元素个数："+c1.size());  // 6
        System.out.println("=======================");
        // iterator()方法
        Iterator it = c1.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
        System.out.println("========================");
        // clear() 方法
        c1.clear();
        System.out.println("集合c1调用clear()方法后的元素个数："+c1.size()); // 0
        System.out.println("=========================");
        c1.add(232);
        c1.add("王五");
        c1.add("王八蛋");
        // contains() 方法
        // 判断集合中是否包含 王五元素
        System.out.println("集合c1中是否包含”王五“元素："+c1.contains("王五"));

        System.out.println("=======================");
        // isEmpty()  判断集合是否包含元素，不包含元素则返回 true
        System.out.println("集合c1是否包含元素："+(c1.isEmpty() ? "不包含": "包含"));
        System.out.println("=====================");
        // remove()
        c1.remove("王五");
        System.out.println("集合c1去除“王五”元素后的元素个数："+c1.size());
    }
}
