package Reflect;

import java.lang.reflect.Field;

public class ReflectTest09 {
    /*class Teacher{
        private int age;
        public String name;
        boolean sex;
        protected int no;
        public static final double MATH_PI = 3.14159265;
    }*/
    public static void main(String[] args) throws Exception {

        Teacher teacher = new Teacher();
        teacher.name = "lixianghuan";
        System.out.println(teacher.name);

        System.out.println("===============");

        Class className =  Class.forName("Reflect.Teacher");
        Object obj = className.newInstance();
        Field nameField = className.getDeclaredField("name");
        nameField.set(obj,"lixianghuan");

        Object obj1 = nameField.get(obj);
        System.out.println(obj1);
        System.out.println("===========");
        Field ageField = className.getDeclaredField("age");
        ageField.setAccessible(true); //打破封装
        ageField.set(obj,19);
        Object obj2 = ageField.get(obj);
        System.out.println(obj2);
    }
}
