package Day7_18;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class LinkTest01 {
    public static void main(String[] args) {
        List list1 = new ArrayList();
//        List link2 = new LinkedList();
//        List link3 = new Vector();
        list1.add("A");
        list1.add("ABC");
        list1.add("ABCD");
        list1.add("ABCDAE");
        list1.add("AAAAA");
        list1.add(1,"LXH");
        Iterator it = list1.iterator();
        int count=0;
        while(it.hasNext()){
            Object obj = it.next();
//            count++;
            System.out.println("第"+(++count) +"集合元素是:"+obj);
        }
        System.out.println("================");
        // get方法获取元素
        Object firstObject = list1.get(0);
        System.out.println("List集合中第一个元素:"+firstObject);
        System.out.println("List集合中的元素个数:"+list1.size());
        System.out.println("===================");
        //利用get方法遍历list集合元素【List集合特有的遍历方法】List集合是有序的  有下标的
        for (int i = 0;i < list1.size();i++){
            Object obj = list1.get(i);
            System.out.println("List集合中的第"+(i+1)+"个元素是:"+obj);
        }
        System.out.println("=================");
        // indexOf  获取列表中第一次出现的指定元素的索引，如果列表不包含该元素，则返回-1

        Object o1 = list1.indexOf("A");
        System.out.println("A在列表中第一次出现的索引为："+o1);
        System.out.println("=================");

        // lastIndexOf  获取列表中最后一次出现的指定元素的索引，如果列表不包含该元素，则返回-1
        Object o2 = list1.lastIndexOf("AAAAA");
        System.out.println("AAAAA在列表中最后一次出现的索引为:"+o2);
        System.out.println("===================");

    }

}
