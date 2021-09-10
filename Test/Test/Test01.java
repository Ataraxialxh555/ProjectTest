public class Test01 {
    private int count;

    public static void main(String[] args) {
        Test01 test = new Test01(88);
        System.out.println(test.count);
    }

    public Test01(int a) {
        count = a;
    }
}
