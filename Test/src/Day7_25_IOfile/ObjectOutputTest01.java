package Day7_25_IOfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputTest01 {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student(15,"zhangsan");
        ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream("Student"));
        oos.writeObject(s1);
        oos.flush();
        oos.close();
    }
}
