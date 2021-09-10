package Day7_21_IO;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) throws Exception{
        PrintStream printStream =  System.out;
        printStream.println("HelloWorld!");
        printStream.println("你好！世界！");
        printStream.println("打印在控制板");
        PrintStream ps = new PrintStream(new FileOutputStream("PrintStreamFile.txt"));
        // 更改打印的位置 打印在PrintStreamFile.txt文件当中
        System.setOut(ps);
        ps.println("Hello World!!!");
        ps.println("Hello SDUT!!!");
        ps.println("Hello JAVA!!!");
        ps.println("Hello GDUT!!!");
    }
}
