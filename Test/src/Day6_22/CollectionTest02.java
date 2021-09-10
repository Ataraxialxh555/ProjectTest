package Day6_22;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest02 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(100);
        c.add("abc");
        c.add(200);
        c.add("edf");
        c.add(new Object());
        Iterator it = c.iterator();
        // hasNext()方法返回 boolean类型的值
        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
