package Day6_2;

public class Student {
    private String name;//成员变量
    private int age;

    public void show(String name) {//局部变量
        System.out.println(this);
        System.out.println(this.name + "你好" + "我来自北京，我是:" + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

