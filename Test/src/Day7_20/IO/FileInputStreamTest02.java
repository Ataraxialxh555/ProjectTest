package Day7_20.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("E:\\IDEA\\IntelliJ IDEA Community Edition 2021.1.1\\Java_Project\\IOStreamFile\\IOfile1.txt");

            int res = 0;
            while((res = fis.read())!=-1){
                System.out.println(res);
            }
            /*while(true){
                int res = fis.read();
                if(res == -1){
                    break;
                }
                System.out.println(res);
            }*/
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
