package Day7_18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ListTest02 {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        List list2 = new ArrayList(100);
        Collection c1 = new HashSet();
        c1.add("a");
        c1.add("nb");
        c1.add("abn");
        c1.add("ab");
        List list3 = new ArrayList(c1);
        for (int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i));
        }
    }
}
