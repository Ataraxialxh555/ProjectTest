package Day7_20;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer>  list = new LinkedList<>();
        //存 add
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(10);
        list.add(20);
        //取 get
        Integer integer = list.get(0);
        System.out.println(integer);
        System.out.println("===========");

        //遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("================");

        for (Integer data:list) {
            System.out.println(data);
        }
        System.out.println("=================");

        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            Integer i  = it.next();
            System.out.println(i);
        }
    }
}
