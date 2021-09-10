package Day6_3;

public class CharAtTest {
    public static void main(String[] args) {
        //String类常用的方法。
        String s1 = "abcdefghijk";
        String s2 = new String("aacadacafafwa");
        char[] chars = new char[]{'a','b','c','d'};
        String s3 = new String(chars);
        //返回指定索引处的char值 charAt
        char c1 = s1.charAt(4);
        char c2 = s2.charAt(4);
        char c3 = s3.charAt(3);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
