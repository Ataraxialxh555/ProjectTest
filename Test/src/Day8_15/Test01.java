package Day8_15;

public class Test01 {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        System.out.println(i);
        int j = i++;
        System.out.println(j);
        System.out.println(i);
//        i = ++i;
//        System.out.println(i);
        int k = i+ ++i * i++;
        System.out.println(k);
        System.out.println(i);
    }
}
