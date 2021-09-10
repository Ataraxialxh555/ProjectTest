package Day7_20.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("E:\\IDEA\\IntelliJ IDEA Community Edition 2021.1.1\\Java_Project\\IOStreamFile\\IOfile1.txt");
            int res = fis.read();
            System.out.println(res);  //a   97
            int res1 = fis.read();
            System.out.println(res1);  //f 102
            int res2 = fis.read();
            System.out.println(res2); // e  101
            int res3 = fis.read();
            System.out.println(res3); // 1   49
            int res4 = fis.read();
            System.out.println(res4); // 1 49

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
