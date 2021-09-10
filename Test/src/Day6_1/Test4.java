package Day6_1;

public class Test4 {
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        for (int i = 10000; i < 99999; i++) {
            a = i / 10000; //万
            b = i / 1000 % 10; //千
            c = i / 100 % 10; //百
            d = i / 10 % 10; //十位
            e = i % 10; //个位
            if (a == e && b == d && a + 1 == b && b + 1 == c) {
                System.out.println(i);
            }
        }
    }
}