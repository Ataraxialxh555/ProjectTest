package Day6_16;

import java.util.ArrayList;
import java.util.Scanner;

public class TestArrayList02 {
    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("请输入学生的姓名：");
            String name = s.next();
            System.out.println("请输入学生的年龄：");
            int age = s.nextInt();
            Student student = new Student(name,age);
            arrayList.add(student);
            if (arrayList.size()==5){
                break;
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Student student = arrayList.get(i);
            System.out.println(student);
        }
    }
}
