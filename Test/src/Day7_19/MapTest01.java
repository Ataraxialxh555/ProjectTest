package Day7_19;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        Map<String,Integer> map1 = new HashMap<>();
        // put 添加键值对
        map1.put("math",99);
        map1.put("english",80);
        map1.put("chinese",88);
        map1.put("computer",100);
        // size 获取Map集合中键值对的个数
        System.out.println(map1.size());
        // get 通过key去获取value的值
        Integer value1 = map1.get("math");
        System.out.println("math的成绩为:"+value1);

        // containsKey  判断Map集合中是否包含key
        boolean b1 = map1.containsKey("math");
        System.out.println("Map集合中是否包含”math“:"+b1);
        //containsValue 判断Map集合中是否包含value
        boolean b2 = map1.containsValue(100);
        System.out.println("Map集合中是否包含”100“:"+b2);
        // remove 通过key删除value   size() Map集合中包含的元素个数
        Integer remove1 = map1.remove("math");
        System.out.println("删除前，Map集合中包含的元素个数："+map1.size());
        System.out.println("删除的value是："+remove1);
        System.out.println("删除"+remove1+"后的Map集合中包含的元素个数："+map1.size());
        // isEmpty
        boolean b3 = map1.isEmpty();
        System.out.println("Map集合是否为空："+b3);
        System.out.println("==================");
        // values()
        Collection<Integer> values = map1.values();
        for (Integer data:values) {
            System.out.println(data);
        }
        System.out.println("==================");
        //clear
        map1.clear();
        System.out.println("clear()后，Map集合中包含的元素个数"+map1.size());
        System.out.println("==================");

    }
}
