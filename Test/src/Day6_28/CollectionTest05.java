package Day6_28;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest05 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(1);
        c1.add(2);
        c1.add(3);
        Object[] objects = c1.toArray();
//        System.out.println(objects);
        for (int i = 0; i < objects.length; i++) {
            Integer b = (Integer)objects[i];
            System.out.println(b);
        }
        System.out.println("==============");
        Integer[] integers = new Integer[c1.size()];
        c1.toArray(integers);
        for (int i = 0; i < integers.length; i++) {
            int v = integers[i];
            System.out.println(v);
        }
    }
}
