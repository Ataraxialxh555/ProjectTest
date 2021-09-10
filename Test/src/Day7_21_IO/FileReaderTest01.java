package Day7_21_IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    FileReader 文件字符输入流
    构造方法：
            FileReader(File file)
            在给定从中读取数据的 File 的情况下创建一个新 FileReader。
    只能处理简单的文本文件 txt
    FileReader和FileWriter需要定义一个char 数组
    FileInputStream 和FileOutputStream需要定义一个byte 数组
 */
public class FileReaderTest01 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("FileTest.txt");
            char[] chars = new char[1024*512]; //1MB
            int countRead = 0;
            while((countRead = fr.read(chars)) != -1){
                System.out.println(new String(chars,0,countRead));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
