package Day7_21_IO;

import java.io.*;

public class BufferedWriterTest {
    public static void main(String[] args) throws Exception{
        /*    FileOutputStream fos = new FileOutputStream("fileTest");
            OutputStreamWriter osw  = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);*/
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fileTest",true)));
            bw.write("Hello World!");
            bw.write("Hello JAVA");
            bw.flush();
            bw.close();
    }
}
