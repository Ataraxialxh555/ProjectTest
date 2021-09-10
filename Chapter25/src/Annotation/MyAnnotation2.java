package Annotation;

public @interface MyAnnotation2 {
    //注解属性 name
    String name();
    //注解属性country  默认值为China
    String country() default "China";
    //注解属性age
    int age();
    //注解属性value
    String value();
    // 枚举数组属性
    Season[] value1();

}
