public class DefaultTest01 {
    public static void main(String[] args) {
        DefaultTest dt = new DefaultTest();
        int result = dt.sub(20, 3);
        System.out.println(result);

        dt.defaultMethod();
        int i = dt.defaultMethod1(20);
        System.out.println(i);

        int a = dt.a;
        System.out.println(a);
        System.out.println(2.1*2.1);
    }
}
