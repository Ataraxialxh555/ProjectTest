package Day5_10;

public class FinalTest3 {
    public static void main(String[] args) {
        Student s1  = new Student(20);
        System.out.println(s1.age);
        Student s2  = new Student();
        System.out.println(s2.age);
    }

}
class Student{
    final int age;
//  这个final可以不先赋值，然后通过构造方法给他赋值
    public Student(){
//        无参数构造方法也需要赋值
        this.age = 10;
    }

    public Student(int age) {
        this.age = age;
    }
}