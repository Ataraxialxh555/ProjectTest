package FirstFeature;

public interface DefaultInterface {
    default void defaultMethod(){
        System.out.println("defaultMethod ִ���ˣ�����");
    }

    int sub(int a ,int b);

    static int a = 5;
}
