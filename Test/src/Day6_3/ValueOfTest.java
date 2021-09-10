package Day6_3;

public class ValueOfTest {
    public static void main(String[] args) {
        String s1 = String.valueOf(100);
        System.out.println(s1);

        String s2 = String.valueOf(true);
        System.out.println(s2);

        char[] chars = {'a','b','c'};
        String s4= String.valueOf(chars);
        System.out.println(s4);

        String s3 = String.valueOf('a');
        System.out.println(s3);
    }
}
