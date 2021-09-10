package Day19;

public class Homework2 {
    public static void main(String[] args) {
        Student s  = new Student();
        s.setAno(2112004135);
        s.setName("lixianghuan");
        s.setAge(24);
        s.display();
    }
}
class Student{
    private int ano;
    private String name ;
    private int age ;

    public Student() {
    }

    public Student(int ano, String name, int age) {
        this.ano = ano;
        this.name = name;
        this.age = age;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display(){
        System.out.println("学生编号："+ano +"\n学生姓名:"+name+"\n学生年龄:"+age);
    }
}