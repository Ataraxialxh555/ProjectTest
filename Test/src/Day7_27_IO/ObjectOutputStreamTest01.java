package Day7_27_IO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest01 {
    public static void main(String[] args) throws Exception{
        Student s = new Student(20,"zhangsan");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentTest01"));
        oos.writeObject(s);
        oos.flush();
        oos.close();
    }
}
