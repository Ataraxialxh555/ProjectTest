package Day5_15;

import java.util.Objects;

public class EqualsTest1 {
    public static void main(String[] args) {
        Student s1 = new Student("ligoudan","yonganshierzhong",120);
        Student s2 = new Student("ligoudan","yonganshierzhong",120);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
class Student{
    private String name;
    private String school;
    private int ano;

    public Student(String name, String school, int ano) {
        this.name = name;
        this.school = school;
        this.ano = ano;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ano == student.ano && name.equals(student.name) && school.equals(student.school);
    }
}