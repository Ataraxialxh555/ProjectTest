package Day6_16;

import java.util.ArrayList;
public class TestArrayList03 {
    public static void main(String[] args) {
        String[] strings = {"唐僧","孙悟空","孙猴子","猪悟能","沙悟净", "孙行者", "小白龙","牛魔王","孙大圣"};
        //创建集合对象
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            //将数组中的元素添加到集合
            arrayList.add(strings[i]);
        }
        System.out.println(arrayList);
        System.out.println("------------");
        //把所有姓孙的人员打印到控制台上。
        for (int i = 0; i < arrayList.size(); i++) {
            String str = arrayList.get(i);
            if(str.startsWith("孙")){
                System.out.println(str);
            }
        }
        System.out.println("------------");
        for (int i = 0; i < arrayList.size(); i++) {
            String str = arrayList.get(i);
            if(str.startsWith("孙")){
                String s=arrayList.remove(i);
//                去除了一个，数组少了一个，所以要i--
                System.out.println(s);
                i--;
            }
        }
        System.out.println(arrayList);
    }
}

