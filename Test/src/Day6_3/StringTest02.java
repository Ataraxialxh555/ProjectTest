package Day6_3;

public class StringTest02 {
    public static void main(String[] args) {
        String s1 = "China";
        String s2 = new String("hello");
        byte[] bytes = new byte[]{88 ,99,100,104};
        String s3 = new String(bytes);
        char[] chars = new char[]{'a','b','c','d'};
        String s4 = new String(chars);
        String s5 = new String(bytes,1,2);
        String s6 = new String(chars,1,2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
    }
}
