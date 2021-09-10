package Day7_19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest02 {
    public static void main(String[] args) {
        Map<Integer,String> map  = new HashMap<>();
        map.put(1,"zhangsan");
        map.put(2,"wangwu");
        map.put(3,"lisi");

        //遍历Map集合 foreach
        Set<Integer> keys = map.keySet();
        for (Integer data:keys) {
            System.out.println(data+"\t"+map.get(data));
        }
        System.out.println("====================");
        // 遍历Map集合 迭代器
        Iterator<Integer> it  = keys.iterator();
        while(it.hasNext()){
            Integer integer = it.next();
            String s = map.get(integer);
            System.out.println(integer+"\t"+s);
        }

        // entrySet

        Set<Map.Entry<Integer,String>> set1 = map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = set1.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> i =iterator.next();
//            System.out.println(i); // 直接输出也行
            Integer integer = i.getKey();
            String str = i.getValue();
            System.out.println(integer+"="+str);
        }
        // foreach
        for (Map.Entry<Integer,String> data:set1) {
//            System.out.println(data); //直接输出也可以
            System.out.println(data.getKey()+"------>"+data.getValue());
        }
    }
}
