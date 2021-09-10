package Day7_21_IO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamTest {
    public static void main(String[]args) throws Exception{
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("DataOutputStreamFile"));
        byte b = 10;
        short s = 20;
        int i = 100;
        long l = 10000L;
        float f = 3.14f;
        double d = 2.232;
        boolean b1 = true;
        char c = 'a';
        dos.writeByte(b);
        dos.writeShort(s);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeBoolean(b1);
        dos.writeChar(c);
        dos.flush();
        dos.close();
        }

}
