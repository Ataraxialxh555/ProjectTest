package Day22;
/*
        第三题：
        按要求编写一个Java应用程序程序：
        （1）定义一个接口CanFly，描述会飞的方法public void fly();
        （2）分别定义类飞机和鸟，实现CanFly接口。
        （3）定义一个测试类，测试飞机和鸟，在main方法中创建飞机对象和鸟对象，

        再定义一个makeFly()方法，其中让会飞的事物飞。
        并在main方法中调用该方法，让飞机和鸟起飞。


 */
public class Homework3 {
    public static void main(String[] args) {
        CanFly airplane = new Airplane();
        CanFly bird = new Bird();

    }

}
interface CanFly{
    public abstract void fly();
}
class Airplane implements CanFly{

    @Override
    public void fly() {
        System.out.println("飞机起飞了！！！！");
    }
    public void makeFly(CanFly canFly,Airplane airplane){
        canFly.fly();
    }
}

class Bird implements CanFly{
    @Override
    public void fly() {
        System.out.println("鸟起飞了，翱翔天空了！！！！");
    }
}