package Day6_21;

public class ExceptionTest {
    public static void main(String[] args) {
        NullPointerException npe = new NullPointerException("空指针异常！");
        System.out.println(npe);
        ArithmeticException are = new ArithmeticException("算术异常！");
        System.out.println(are);
    }
}
