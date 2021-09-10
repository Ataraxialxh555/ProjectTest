package Day6_21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest04 {
    public static void main(String[] args) {
        //m1 编译时出现异常是因为m1 抛出了异常throws IOException
        System.out.println("main begin ");
        try {
            m1();
            System.out.println("hello world!");
        } catch (IOException e) {
            System.out.println("找不到路径！！！");
        }
        System.out.println("main over");
    }

    public static void m1() throws IOException {
        System.out.println("m1 begin");
        //m2 编译时出现异常是因为m2 抛出了异常throws FileNotFoundException
        m2();
        System.out.println("m1 over");
    }

    public static void m2() throws FileNotFoundException{
        System.out.println("m2 begin");
        // m3编译时出现异常是因为m3 抛出了异常throws FileNotFoundException
        // 这里上抛异常 只能抛给异常的父类（IOException或者Exception）或者异常（FileNotFoundException）
        m3();
        System.out.println("m2 over");
    }

    public  static void m3() throws FileNotFoundException{
        System.out.println("m3 begin");
        // m4 编译时出现异常是因为m4 抛出了异常throws FileNotFoundException
        m4();
        System.out.println("m3 over");
    }

    public  static void m4() throws FileNotFoundException {
        // FileInputStream 出现异常是因为FileInputStream 源代码抛出了异常throws FileNotFoundException
        FileInputStream fi = new FileInputStream("E:\\Jaa学习视频\\课堂笔记\\day01-课程随笔.txt");
    }
}
