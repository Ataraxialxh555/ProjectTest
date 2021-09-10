package Day7_20.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest05 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("FileTest01.txt");
            byte[] bytes = new byte[4];
            /*while(true){
                int count = fis.read(bytes);
                if(count == -1){
                    break;
                }
                System.out.println(new String(bytes,0,count));
            }*/
            int count = 0;
            while((count = fis.read(bytes))!= -1){
                System.out.print(new String(bytes,0,count));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
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
