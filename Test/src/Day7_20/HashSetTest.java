package Day7_20;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("c");
        set.add("b");
        set.add("e");
        set.add("d");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String s1 = it.next();
            System.out.println(s1);
        }
        System.out.println("=================");
        for (String data:set) {
            System.out.println(data);
        }

    }
}
