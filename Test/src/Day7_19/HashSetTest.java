package Day7_19;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        // HashSet
        //无序不可重复
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("Hello");
        set.add("Hello");
        set.add("World!");
        set.add("Kitty");
        set.add("nihao!");
        set.add("goudan!");
        set.add("wangda");
        for (String data:set){
            System.out.println(data);
        }
        System.out.println("===============");

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }
}
