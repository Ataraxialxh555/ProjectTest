package Day6_2;

public class Test {
    public static void main(String[] args) {
        //创建对象
        // String(String original)
        String str1 = new String("hello");
        System.out.println(str1);
        //String(char[] value)
        char[] chs = {'c','h','i','n','a'};
        String str2 = new String(chs);
        System.out.println(str2);
        // String(char[] value, int offset, int count)
        char[] chs2 = {'c','h','i','n','a'};
        String str3 = new String(chs2,2,3);
        System.out.println(str3);
        String str4 = "hello china";
        System.out.println(str4);
    }
}
