package Day7_25_IOfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest01 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Student"));
        Object o = ois.readObject();
        System.out.println(o);
        ois.close();
    }
}
