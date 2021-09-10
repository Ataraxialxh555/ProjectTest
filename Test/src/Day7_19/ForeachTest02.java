package Day7_19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForeachTest02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("nihao!");
        // 使用迭代器迭代遍历循环
        Iterator<String> it = list.iterator();
        
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("================");
        // 使用下标的方式循环遍历
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("================");
        //使用foreach循环
        for(String data :list){
            System.out.println(data);
        }
    }
}
