package Day7_20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String>  list =  new ArrayList<>();
        //存集合元素add
        list.add("zhangsan");
        list.add("wangwu");
        list.add("zhaoliu");
        // 取get
        System.out.println(list.get(1)); // wangwu
        System.out.println("==============");
        //遍历
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("==============");
        for (String data:list){
            System.out.println(data);
        }
        System.out.println("===============");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
