package Day6_28;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest01 {
    public static void main(String[] args) {
        //ArrayList 有序可重复 HashSet 无序不可重复
        Collection  c1 = new ArrayList();
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(3.23);
        Iterator it = c1.iterator();
        // 存进去是什么类型，取出来就是什么类型
        while(it.hasNext()){
            Object obj = it.next();
            if (obj instanceof  Integer){
                System.out.println("Integer类型");
            }else if (obj instanceof Double){
                System.out.println("Double类型");
            }
            System.out.println(obj);
        }
    }
}
