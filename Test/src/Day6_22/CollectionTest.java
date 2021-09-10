package Day6_22;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(1200);
        collection.add(30.20);
        collection.add(new Object());
        collection.add(new Student());
        collection.add("Hello");
        System.out.println("Collection集合的个数："+collection.size());
        collection.clear();
        System.out.println("clear清空后，Collection集合的个数："+collection.size());
        collection.add("Hello");
        collection.add(1200);
        collection.remove(1200);
        System.out.println("Collection集合的个数："+collection.size());
        boolean flag = collection.contains(1200); //false
        boolean flag1 = collection.contains("Hello"); //true
        System.out.println(flag);
        System.out.println(flag1);

        boolean flag2 = collection.isEmpty();
        System.out.println(flag2);

        collection.clear();
        System.out.println(collection.isEmpty());
        System.out.println("=================");
        collection.add(1200);
        collection.add(30.20);
        collection.add(new Object());
        collection.add(new Student());
        Object[] obj = collection.toArray();
        for (int i = 0;i < obj.length;i++){
            System.out.println(obj[i]);
        }

    }
}
class Student{

}