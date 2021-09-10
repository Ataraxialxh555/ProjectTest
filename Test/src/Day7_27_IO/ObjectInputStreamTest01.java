package Day7_27_IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest01 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudentTest01"));
        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();


    }
}
