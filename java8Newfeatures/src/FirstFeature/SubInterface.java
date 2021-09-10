package FirstFeature;

public interface SubInterface extends  DefaultInterface{
    @Override
    default void defaultMethod() {
        DefaultInterface.super.defaultMethod();
        System.out.println("子类defaultMethod执行了！！！");
    }

    @Override
    int sub(int a, int b);
}
