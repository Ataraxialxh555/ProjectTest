package Reflect;

public class ReflectTest04 {
    public static void main(String[] args) {
        try {
            Class.forName("Reflect.People");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class People{
    static {
        System.out.println("静态代码块执行了!!!");
    }
}