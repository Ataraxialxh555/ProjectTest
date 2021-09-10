package Day7_27_IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectInputStreamTest02 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudentTest02"));
        List<Student> lists = (List<Student>)ois.readObject();

        for(Student list:lists){
            System.out.println(list);
        }
        ois.close();
    }
}
