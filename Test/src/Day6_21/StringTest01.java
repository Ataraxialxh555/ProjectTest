package Day6_21;

public class StringTest01 {
    public static void main(String[] args) {
        byte[] bytes = {'a', 'b', 'c', 'e', 's'};
        String s = new String(bytes, 1, 2);
        System.out.println(s);
        char[] chars = {'a', 'c', 's', 'e', 'c'};
        String s1 = new String(chars, 0, 3);
        System.out.println(s1);
        String s2 = new String(chars);
        System.out.println(s2);
    }
}
