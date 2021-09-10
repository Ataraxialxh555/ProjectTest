package Day7_20.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
FileInputStream类其他常用的方法
    int available() ：返回流当中剩余的没有读到的字节数量
    long skip(long n) :跳过几个字节不读

*/
public class FileInputStreamTest06 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("FileTest.txt");
            System.out.println("总字节数："+fis.available());
            byte[] bytes = new byte[4];
            int countRead = fis.read(bytes); // 读取到的字节个数 4
            String s = new String(bytes,0,countRead);;
            System.out.println(s);
            System.out.println("read之后的字节数："+fis.available());
            long long1 = fis.skip(4);
            System.out.println("跳过去"+long1+"个字节的数据");
            System.out.println("跳过4个字节之后的字节数："+fis.available());
            countRead = fis.read(bytes);
            String s1 = new String(bytes,0,countRead);
            System.out.println(s1);
            System.out.println("剩余的字节节数："+fis.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
