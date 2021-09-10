import org.junit.Test;

import java.util.*;

public class MapTest {
    @Test
    public void testMap1(){

        Map<String,String> map = new HashMap<>();
        map.put("1","zhangsan");
        map.put("2","wangwu");
        map.put("3","lisi");
        map.put("4","zhaoliu");
        System.out.println("通过Map.ketSet遍历key和value");

        for (String key:map.keySet()){
            System.out.println("key="+key+" and value="+map.get(key));
        }
    }
    @Test
    public void testMap2(){
        Map<String,String> map = new HashMap<>();
        map.put("1","zhangsan");
        map.put("2","wangwu");
        map.put("3","lisi");
        map.put("4","zhaoliu");
        System.out.println("通过Map.entrySet使用Iterator遍历key和value");
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue());
        }
    }


    @Test
    public void testMap3(){
        Map<String,String> map = new HashMap<>();
        map.put("1","zhangsan");
        map.put("2","wangwu");
        map.put("3","lisi");
        map.put("4","zhaoliu");
        System.out.println("通过Map.entrySet遍历key和value");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue());
        }
    }
    @Test
    public void testMap4(){
        Map<String,String> map = new HashMap<>();
        map.put("1","zhangsan");
        map.put("2","wangwu");
        map.put("3","lisi");
        map.put("4","zhaoliu");
        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }

    }
}
