package Day7_19;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        // TreeSetTest 可排序集合  无序不可重复
        Set<Integer> set = new TreeSet<>();
        set.add(100);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(100);
        set.add(20);
        set.add(40);
        set.add(320);
        set.add(210);
        for (Integer data:set) {
            System.out.println(data);
        }
        System.out.println("===============");

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer s = it.next();
            System.out.println(s);
        }
      /*  20
        30
        40
        100
        210
        320*/
    }
}
