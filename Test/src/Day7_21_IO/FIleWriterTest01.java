package Day7_21_IO;

import java.io.FileWriter;
import java.io.IOException;

public class FIleWriterTest01 {
    public static void main(String[] args) {
        FileWriter fw  = null;
        try {
            fw = new FileWriter("FileWriterTest.txt",true);
            char[] chars = {97,98,99,100,101,120,102,103};
            fw.write(chars,0,2);
            fw.write("你好啊！！！");
            fw.write(111);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
