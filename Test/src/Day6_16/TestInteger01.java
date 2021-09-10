package Day6_16;

public class TestInteger01 {
    public static void main(String[] args) {
//        Integer i = new Integer(120); // 这种写法过时了
        Integer i =120; //这种写法直接就行了，直接装箱，基本数据类型----->引用数据类型
        int i1 = i.intValue();  //拆箱，转换为基本数据类型
        System.out.println(i1);
        float f = i.floatValue();  //拆箱
        System.out.println(f);
    }
}
