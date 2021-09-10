package Day6_16;

import java.util.ArrayList;
public class TestArrayList {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("2020");
        arrayList.add("你好呀");
        arrayList.add("开心每一天");
        arrayList.add("嘻嘻哈哈");
        System.out.println(arrayList);
        //遍历输出
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.get(3));
        System.out.println("-------------------");
        for (int i = 0; i < 4; i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("-------------------");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
