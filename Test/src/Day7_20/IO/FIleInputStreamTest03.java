package Day7_20.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FIleInputStreamTest03 {
    //IDEA默认当前路径是在整个工程下的根
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //相对路径：以IDEA默认当前路径往下找！
            fis = new FileInputStream("IOStreamFile\\IOfile1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
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
