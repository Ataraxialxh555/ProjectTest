package Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static Annotation.Season.WINTER;

public class AnnotationTest01 {
    // country 注解属性可以不用赋值  ，有默认值China，其他的注解属性必须赋值
    @MyAnnotation2(name = "lixianghuan",age = 24,value = "hehe",value1 = {Season.SPRING,Season.WINTER})
    public void doSome(){
        System.out.println("doSome！！！！！！！！");
    }
}
