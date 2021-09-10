package Reflect;

public class ReflectTest02 {
    public static void main(String[] args) {
        //直接创建对象
        User user = new User();
        System.out.println(user);


        // 利用反射机制的方式创建对象
        try {
            //Class 后面可以跟泛型
            Class<User> c1 = (Class<User>)Class.forName("Reflect.User");
            Object obj = c1.newInstance();
            Object obj1 = c1.newInstance();
            System.out.println(obj);
            System.out.println(obj1);
            System.out.println(obj==obj1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class User{
    public User(){
        System.out.println("User的无参数构造方法!");
    }
}