package Day7_21_IO;

import java.io.*;

public class BufferedReaderTest02 {
    public static void main(String[] args) throws Exception{

           /* FileInputStream fis = new FileInputStream("FileTest.txt");
            // fis 是节点流 isr是包装流  InputStreamReader可以将字节流转换为字符流
            InputStreamReader isr = new InputStreamReader(fis);
            // isr 是节点流 br是包装流   节点流和包装流是相对而言的
            BufferedReader br  = new BufferedReader(isr);  // 括号里的参数必须是字符流*/
            BufferedReader br  = new BufferedReader(new InputStreamReader(new FileInputStream("FileTest.txt")));
            String s = null;
            while((s = br.readLine())!=null) {
                System.out.println(s);
            }

            br.close();
    }
}
