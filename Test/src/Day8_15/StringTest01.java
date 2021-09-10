package Day8_15;

public class StringTest01 {
    public static void main(String[] args) {
        String s = "HelloWorld";
        System.out.println(s);

        String s1 = new String("ÄãºÃ");
        System.out.println(s1);

        char[] chars = {'C','h','i','n','a'};
        String s2 = new String(chars);
        System.out.println(s2);

        String s3 = new String(chars,1,2);
        System.out.println(s3);
    }
}
