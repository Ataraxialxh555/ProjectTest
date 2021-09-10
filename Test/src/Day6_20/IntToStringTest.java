package Day6_20;

public class IntToStringTest {
    public static void main(String[] args) {
        // 方法一：int+""
        int i = 10;
        String s = i + "a";
        System.out.println(s);
        // 方法二：String.valueOf
        int i1 = 200;
        String s1 = String.valueOf(i1);
        System.out.println(s1);
    }
}
