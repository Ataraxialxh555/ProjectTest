package Day6_21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest05 {
    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        System.out.println("m1 begin ");
        m2();
        System.out.println("m1 over ");
    }

    private static void m2() {
            try {
                new FileInputStream("E:\\Java学习视频\\课堂笔记\\day01-课程随笔.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
}
