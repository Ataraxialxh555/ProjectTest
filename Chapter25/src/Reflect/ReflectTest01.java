package Reflect;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReflectTest01 {
    public static void main(String[] args) {
       //第一种方式 获取Class的字节码
        Class c1 = null;
        Class c2 = null;
        Class c3 = null;
        try {
            c3 = Class.forName("java.text.SimpleDateFormat");
            c1 = Class.forName("java.lang.String");
            c2 = Class.forName("java.util.Date");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //第二种方式
        String s = "abc";
        Class  class1 = s.getClass();
        System.out.println(c1 == class1);

        Date date = new Date();
        Class class2 = date.getClass();
        System.out.println(class2 == c2);
        // 第三种方式
        Class z = String.class;
        Class class3 = int.class;
        Class class4 = Integer.class;
        System.out.println(z == c1);

    }
}
