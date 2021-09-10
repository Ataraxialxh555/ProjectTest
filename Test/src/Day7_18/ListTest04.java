package Day7_18;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest04 {
    public static void main(String[] args) {
        List myList = new LinkedList();
        // 使用Collections.synchronizedList  方法将非线程安全的转换为线程安全的。
        Collections.synchronizedList(myList);
        myList.add("aaa");
        myList.add("bbb");
        myList.add("ccc");
        myList.add("ddd");
        myList.add("eee");
        Iterator it = myList.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
