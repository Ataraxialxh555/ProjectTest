package Annotation2;

@MyAnnotation("上海浦东区")
public class MyAnnotationTest {
    @MyAnnotation("广州天河区")
    public void doSome(){
        System.out.println("doSome!!!!!");
    }
}
