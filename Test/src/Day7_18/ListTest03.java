package Day7_18;

import java.util.LinkedList;
import java.util.List;

public class ListTest03 {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
