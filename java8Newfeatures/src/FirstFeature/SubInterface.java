package FirstFeature;

public interface SubInterface extends  DefaultInterface{
    @Override
    default void defaultMethod() {
        DefaultInterface.super.defaultMethod();
        System.out.println("����defaultMethodִ���ˣ�����");
    }

    @Override
    int sub(int a, int b);
}
