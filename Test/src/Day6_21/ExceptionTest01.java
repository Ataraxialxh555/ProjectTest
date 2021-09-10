package Day6_21;

public class ExceptionTest01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        //实际上JVM在执行到此处的时候，会new异常对象，
        // new ArithmeticException("/ by zero");
        //并且JVM会将new出来的异常信息，打印输出到控制台
        int c = a/b;
        System.out.println(a+"/"+b +"="+c);
    }
}
