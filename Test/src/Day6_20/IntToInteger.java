package Day6_20;

public class IntToInteger {
    public static void main(String[] args) {
        //方法一：自动装箱
        Integer i = 100;
        System.out.println(i);
        //方法二：valueOf
        Integer i1 = Integer.valueOf(200);
        System.out.println(i1);
    }
}
