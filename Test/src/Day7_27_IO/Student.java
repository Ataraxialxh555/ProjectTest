package Day7_27_IO;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = -6636340009263785809L;
    private int age;
    private String name;
    public Student(){}
    public Student(int age,String name){
        this.age = age;
        this.name = name;
    }
    public void setAge(int age ){
        this.age = age;
    }
    public int getAge(int age){
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
