package Day6_16;

public class TestInteger {
    public static void main(String[] args) {
        MyInt myInt = new MyInt(100);
        // 通过构造方法将100包装成一个对象
        // 将基本数据类型100包装为一个引用数据类型，这样调用方法doSome()可以传入这个100
        doSome(myInt);
    }
    public static void doSome(Object object){
        System.out.println(object);
    }
}
