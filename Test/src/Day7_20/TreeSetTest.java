package Day7_20;


import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("wangwu");
        set.add("zhangwu");
        set.add("zhangsan");
        set.add("lisi");
        set.add("zhangsi");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("=============");
        for(String data:set){
            System.out.println(data);
        }
    }
}
