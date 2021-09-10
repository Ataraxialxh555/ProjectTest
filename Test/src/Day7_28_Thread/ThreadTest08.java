package Day7_28_Thread;

public class ThreadTest08 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable4());
        thread.setName("A");
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"----->"+i);
        }
    }
}
class MyRunnable4 implements  Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //每10个让位一个
            if (i % 5 == 0){
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+"------>"+i);
        }
    }
}