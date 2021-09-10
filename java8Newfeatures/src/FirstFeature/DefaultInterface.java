package FirstFeature;

public interface DefaultInterface {
    default void defaultMethod(){
        System.out.println("defaultMethod ÷¥––¡À£°£°£°");
    }

    int sub(int a ,int b);

    static int a = 5;
}
