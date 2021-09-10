package Day6_3;

public class CompareToTest {
    public static void main(String[] args) {
        String s1 ="abc";
        String s2 = new String("abc");
        String s3 = "abc";
        //compareTo 比较两个字符串，1为true ，0为false
        int i  = s1.compareTo(s2);
        int i1  = s1.compareTo(s3);
        System.out.println(i);  //0
        System.out.println(i1); //1
        //contains 判断前面字符串中是否包含后面的字符串
        boolean b1 = s1.contains("a");

    }
}
