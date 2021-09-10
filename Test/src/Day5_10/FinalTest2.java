package Day5_10;

public class FinalTest2 {
    final int j=100;// 实例变量必须赋初始值。
    public static void main(String[] args) {
        //局部变量 final修饰的局部变量有且只能赋一次值；
        final int i;
        i = 10;
//        无法将值赋给 final 变量 'p'
        final Person p = new Person(15,"li");
//        可以通过引用.属性来修改 final修饰的对象 的内部属性
        p.setAge(20);
        p.setName("wang");
        System.out.println(p.getAge());
        System.out.println(p.getName());
        /*
        final Person p = new Person();
        p = new Person(15,"li");
        */
    }
}
class Person{
    private int age ;
    private String name;
    public Person(){

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}