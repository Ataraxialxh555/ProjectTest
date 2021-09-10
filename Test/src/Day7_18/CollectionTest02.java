package Day7_18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest02 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add("acb");
        c1.add("edf");
        c1.add("eeee");
        Iterator it = c1.iterator();
        while(it.hasNext()){
            Object obj = it.next();
//            c1.remove(obj);  //不要使用集合自带的remove 方法删除元素，会出现异常ConcurrentModificationException
            it.remove();
            System.out.println(obj);
        }
        System.out.println("使用Iterator中的remove方法删除元素后的集合元素个数："+c1.size());
    }

}
