package Day7_27_IO;

public class ThreadTest02 {
    public static void main(String[] args) {
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);
        //匿名内部类
        //使用匿名内部类来实现抽象方法
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("分支线程------->"+i);
                }
            }
        });
        thread.start();

        for (int i = 0; i < 1000; i++){
            System.out.println("主线程------->"+i);
        }
    }
}
//class MyRunnable implements  Runnable{
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            System.out.println("分支线程---------->"+i);
//        }
//    }
//}