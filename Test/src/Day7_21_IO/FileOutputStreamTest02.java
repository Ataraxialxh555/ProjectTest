package Day7_21_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamTest02 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("FileTest03.txt",true);
            byte[] bytes = {98,99,100,101,102,103};
//            fos.write(bytes);
            fos.write(bytes,0,2);
            String s= "战狼魂";
            byte[] byte1 = s.getBytes();
            fos.write(byte1);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
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
