package Day7_19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest02 {
    public static void main(String[] args) {
        // 钻石表达式 类型自动推断
        List<Animal>  list = new ArrayList<>();
        Cat cat = new Cat();
        Bird bird = new Bird();
        list.add(cat);
        list.add(bird);
        Iterator<Animal>  it = list.iterator();
        while(it.hasNext()){
            Animal a = it.next();
            a.move();
        }

        List<String> list1 = new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");

        Iterator<String> it2 = list1.iterator();
        while (it2.hasNext()){
            String s = it2.next();
            String s1 = s.substring(1);
            System.out.println(s1);
        }


    }
}
