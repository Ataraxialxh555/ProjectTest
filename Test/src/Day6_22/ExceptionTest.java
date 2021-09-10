package Day6_22;

public class ExceptionTest {
    public static void main(String[] args) {
        MyException myException = new MyException("用户名不能为空！！");
        //打印异常堆栈信息
        myException.printStackTrace();
        // 获取异常简单描述信息
        String msg = myException.getMessage();
        System.out.println(msg);
    }
}
