package Day7_21_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest03 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("FileTest.txt");
            fos = new FileOutputStream("FileTest_Copy");
            int sumRead = fis.available();
            byte[] bytes = new byte[sumRead];
            int countRead = fis.read(bytes);
            String res = new String(bytes,0,countRead);
            byte[] bytes2 = res.getBytes();
            fos.write(bytes2);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{

            //分开try catch
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
