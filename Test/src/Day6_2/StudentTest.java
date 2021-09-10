package Day6_2;

public class StudentTest {
    public static void main(String[] args) {
        Student stu = new Student();
        System.out.println(stu);
        //对成员变量进行赋值
        stu.setName("小明");
        stu.setAge(38);
        stu.show("小红");
        System.out.println("======================");
        Student stu2 = new Student();
        System.out.println(stu2);
        stu2.setName("小李");
        stu2.show("小军");
    }
}
