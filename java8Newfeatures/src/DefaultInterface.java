public interface DefaultInterface {
    int sub(int a ,int b);
    static void staticMethod(){
        System.out.println("staticMethod方法执行了！");
    }
    default void defaultMethod(){
        System.out.println("defaultMethod方法执行了！");
    }

    default int defaultMethod1(int a) {
        return a;
    }

    static int a = 5;

}
