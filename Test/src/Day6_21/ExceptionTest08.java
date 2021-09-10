package Day6_21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest08 {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try{
            fis = new FileInputStream("E:\\Java学习视频\\课堂笔记\\day01-课程随笔.txt");
            String s = null;
            s.toString();
            System.out.println("Hello world!!!!!");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }finally {
            System.out.println("hello world");
                if (fis != null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
        System.out.println("hello LXH");

    }
}
