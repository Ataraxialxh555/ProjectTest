package Day7_21_IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader("FileWriterTest.txt");
            br = new BufferedReader(fr);
            String str = null;
            while((str = br.readLine())!=null){
               System.out.println(str);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
