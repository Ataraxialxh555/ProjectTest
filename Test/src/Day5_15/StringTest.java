package Day5_15;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);
        String s3 = new String("Hello");
        String s4 = new String("Hello");
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("-----------------------");
        MyTime mt = new MyTime(2020,2,1);
        System.out.println(mt.toString());
    }
}
