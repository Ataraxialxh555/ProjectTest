package Annotation2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectAnnotationTest01 {
    public static void main(String[] args) throws Exception {
        //获取这个类
        Class myClass = Class.forName("Annotation2.MyAnnotationTest");
        //判断类上是否有@MyAnnotation
        System.out.println(myClass.isAnnotationPresent(MyAnnotation.class));

        if(myClass.isAnnotationPresent(MyAnnotation.class)){
            //获取该注解对象
            MyAnnotation myAnnotation = (MyAnnotation) myClass.getAnnotation(MyAnnotation.class);
            //获取注解对象的属性
            String s = myAnnotation.value();
            System.out.println(s);
        }

        Method myMethod = myClass.getDeclaredMethod("doSome");
        if(myMethod.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation = myMethod.getAnnotation(MyAnnotation.class);
            String s = myAnnotation.value();
            System.out.println(s);
        }

        Class stringClass = Class.forName("java.lang.String");
        System.out.println(stringClass.isAnnotationPresent(MyAnnotation.class));
    }
}
