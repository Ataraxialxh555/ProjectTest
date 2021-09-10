package Day7_20.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest07 {
        public static void main(String[] args) {
            FileInputStream fis = null;
            // available 对大文件的数据获取数据的长度， 不能一次性读取完毕
            try {
                fis = new FileInputStream("FileTest.txt");
                int res = fis.available();
                byte[] bytes = new byte[res];
                int countRead = fis.read(bytes);
                System.out.println(new String(bytes,0,countRead));
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
