package Day8_15;

public class Test03 {
    public static void main(String[] args) {
        int a = 10;
        int b = 9;
        int c = (--a != b++) ? --a : ++b;
        System.out.println(c);

    }
}
