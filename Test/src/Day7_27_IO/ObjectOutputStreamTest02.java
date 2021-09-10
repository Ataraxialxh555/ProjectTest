package Day7_27_IO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamTest02 {
    public static void main(String[] args) throws Exception{
        List<Student> list =  new ArrayList<>();
        list.add(new Student(20,"zhangsan"));
        list.add(new Student(22,"zhangwu"));
        list.add(new Student(23,"lisi"));
        list.add(new Student(24,"zhangquandan"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentTest02"));
        oos.writeObject(list);
        oos.flush();
        oos.close();
    }
}
