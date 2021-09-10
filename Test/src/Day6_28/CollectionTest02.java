package Day6_28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest02 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add("abc");
        c1.add("bef");
        Iterator it = c1.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
        String s1 = new String("abc");

        System.out.println(c1.contains(s1));

        String s2 = new String("bef");

        System.out.println(c1.contains(s2));
    }
}
