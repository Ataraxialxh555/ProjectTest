package Day7_17;

public class Test4 {
    public static void main(String[] args) {
        Person per = null;
        per = new Person();
        per.name = "lxh";
        per.age = 24;
        per.tell();
    }
}
class Person{
    int age;
    String name;
    public void tell(){
        System.out.println("Age:"+age+"Name:"+name);
    }
}
