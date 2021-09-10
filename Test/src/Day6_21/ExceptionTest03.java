package Day6_21;

import java.io.IOException;

public class ExceptionTest03 {
    public static void main(String[] args) throws IOException {
        /*
        try {
            doOther(); //编译时异常，需要在编译过程中对其进行异常的处理
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        doOther();
        //必须对其进行捕获try catch或者抛出throws
    }
    public static void doOther() throws IOException {
        System.out.println("doOther!!!!!!!");
    }
}
