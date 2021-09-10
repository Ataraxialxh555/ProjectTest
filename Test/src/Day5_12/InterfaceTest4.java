package Day5_12;

public class InterfaceTest4 {
    public static void main(String[] args) {
        F f = new F();
        f.m1();
        f.m2();
    }
}
interface D{
    public abstract void m1();
}
interface E{
    public abstract  void m2();
}
//类可以同时实现多个接口
class F implements D,E{
    public  void m1(){
        System.out.println("接口D的m1()方法");
    }

    public void m2(){
        System.out.println("接口E中的m2()方法");
    }
}