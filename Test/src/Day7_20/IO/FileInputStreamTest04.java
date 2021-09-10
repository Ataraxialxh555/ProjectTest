package Day7_20.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest04 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("FileTest.txt");
            byte[]  bytes = new  byte[4];
            try {
                int count = fis.read(bytes);
                System.out.println(count);
                String s1 = new String(bytes,0,count);
                System.out.println(s1);

                count = fis.read(bytes);
                System.out.println(count);
                String s2 = new String(bytes,0,count);
                System.out.println(s2);

                count = fis.read(bytes);
                System.out.println(count);


            } catch (IOException e) {
                e.printStackTrace();
            }
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
