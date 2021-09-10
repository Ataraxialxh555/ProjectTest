package Day6_28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest04 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(4);
        c1.add(5);
        Collection c2 = new ArrayList();
        c2.add(c1);
        c2.add(66);
        Iterator it = c2.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
        System.out.println("c2的长度"+c2.size()); //2
        System.out.println("=============");
        //addAll 和add区别
        Collection c3 = new ArrayList();
        c3.addAll(c1);
        c3.add(66);
        Iterator it2 = c3.iterator();
        while(it2.hasNext()){
            Object obj = it2.next();
            System.out.println(obj);
        }
        System.out.println("c3的长度"+c3.size());//6

    }
}
