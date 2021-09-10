package Day6_16;
import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) {
                ArrayList<String> arrayList = new ArrayList<String>();
                //boolean add(E e)
                boolean flag = arrayList.add("花千骨");
                arrayList.add("花千骨");
                System.out.println(flag);
                System.out.println(arrayList);
                System.out.println("--------------");
                //void add(int index, E element)
                arrayList.add(1,"白子画");
                System.out.println(arrayList);
                System.out.println("--------------");
                //E get(int index)
                String str = arrayList.get(2);
                System.out.println(str);
                System.out.println("--------------");
                //int size()
                int size = arrayList.size();
                System.out.println(size);
                System.out.println("--------------");
                //E remove(int index)
                String remove1 = arrayList.remove(1);
                System.out.println(remove1);
                System.out.println(arrayList);
                System.out.println("--------------");
                //boolean remove(Object o)
                arrayList.remove("花千骨");
                System.out.println(arrayList);
                System.out.println("--------------");
                //E set(int index, E element)
                String set = arrayList.set(0, "糖宝");
                System.out.println(set);
                System.out.println(arrayList);
                System.out.println("--------------");
                //其他方法
                //clear():
                //arrayList.clear();
                //System.out.println(arrayList);
                //isEmpty()
                boolean empty = arrayList.isEmpty();
                System.out.println(empty);
                //contains()
                boolean contains = arrayList.contains("糖宝");
                System.out.println(contains);
                //indexOf()
                int indexOf = arrayList.indexOf("糖宝");
                System.out.println(indexOf);
                //lastIndexOf()
                int lastIndexOf = arrayList.lastIndexOf("糖宝");
                System.out.println(lastIndexOf);
                //toArray()
                Object[] objects = arrayList.toArray();
                for (int i = 0; i < objects.length; i++) {
                    System.out.println(objects[i]);
                }
    }
}
