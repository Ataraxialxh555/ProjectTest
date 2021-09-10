package Day7_20;

import java.util.Set;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        //存 put
        map.put("math",99);
        map.put("english",89);
        map.put("computer",100);
        map.put("chinese",85);
        map.put("english",85);
        System.out.println(map.size()); //4
        System.out.println("=================");
        //get:取value
        Integer value1 = map.get("math");
        System.out.println(value1);
        System.out.println("=================");
        // keySet:取key
        Set<String> s = map.keySet();
        for (String data:s){
            System.out.println(data);
        }
        //遍历
        System.out.println("========遍历方法一==========");
        for (String data:s){
            System.out.println(data+"="+map.get(data));
        }
        System.out.println("======遍历方法二========");
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for (Map.Entry<String,Integer> data:entries) {
            System.out.println(data);
        }

        System.out.println("=======遍历方法三=======");
        for (Map.Entry<String,Integer> data:entries) {
            System.out.println(data.getKey()+"="+data.getValue());
        }
    }
}
