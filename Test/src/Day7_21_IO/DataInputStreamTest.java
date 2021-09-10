package Day7_21_IO;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;

public class DataInputStreamTest {
    public static void main(String[] args) throws Exception{
        DataInputStream dis = new DataInputStream(new FileInputStream("DataOutputStreamFile"));
       //读的顺序要一致，一个地方错都可能导致读出来的数据和存进去的数据不一样！
        byte b = dis.readByte();
        short s = dis.readShort();
        int i = dis.readInt();
        long l = dis.readLong();
        float f  = dis.readFloat();
        double d = dis.readDouble();
        boolean b1 =dis.readBoolean();
        char c = dis.readChar();
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(b1);
        System.out.println(c);
    }
}
