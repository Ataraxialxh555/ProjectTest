package Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest07 {
    public static void main(String[] args) throws Exception {
        Class className = Class.forName("Reflect.Teacher");
        System.out.println(className);
        // 获取所有的Field
        Field[] fields = className.getDeclaredFields();
        //   Field[] fields = Reflect.Teacher.class.getDeclaredFields();
        System.out.println("Teacher类的所有属性个数："+fields.length); //5
        for(Field field1:fields){
            int i = field1.getModifiers();
            String s = Modifier.toString(i);
            System.out.println(s);
            String s1 = field1.getType().getSimpleName();
            System.out.println(s1);
            System.out.println(field1.getName());
        }

        System.out.println("=======================");
        // 获取public修饰的Field
        Field[] field = className.getFields();
        System.out.println("Teacher类中public修饰的属性个数:"+field.length);  //2
        for(Field field2:field){
            int i = field2.getModifiers();
            String s = Modifier.toString(i);
            System.out.println(s);
            String s1 = field2.getType().getSimpleName();
            System.out.println(s1);
            System.out.println(field2.getName());
        }
    }
}
class Teacher{
    private int age;
    public String name;
    boolean sex;
    protected int no;
    public static final double MATH_PI = 3.14159265;
}