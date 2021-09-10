package Day6_20;

public class IntegerToInt {
    public static void main(String[] args) {
        //自动拆箱
        Integer i = 100;
        int i1 = i;
        System.out.println(i1);
        //intValue
        int i2 = i.intValue();
        System.out.println(i2);
    }
}
