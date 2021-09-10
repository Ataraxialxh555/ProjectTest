package Day6_21;

public class ExceptionTest07 {
    public static void main(String[] args) {
        NullPointerException npe = new NullPointerException("空指针异常！");
        String  msg = npe.getMessage();
        System.out.println(msg);
        npe.printStackTrace();
        System.out.println("hello world!");
    }
}
