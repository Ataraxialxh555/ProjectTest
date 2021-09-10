public class LambdaTest01 {
    //无参数无返回值的Lambda表达式
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("测试无参数无返回值的Lambda表达式");
            }
        };
        runnable.run();


        System.out.println("==============");
        Runnable runnable1 = () -> System.out.println("测试无参数无返回值的Lambda表达式");
        runnable.run();

    }
}
