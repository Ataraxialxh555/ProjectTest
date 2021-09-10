package Day7_28_Thread;

public class ThreadTest05 {
    public static void main(String[] args) {
        MyRunnable1 myRunnable= new MyRunnable1();
        Thread thread = new Thread(myRunnable);
        thread.start();
        // 睡眠5s
        try {
            thread.sleep(1000*5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       thread.stop();

        System.out.println(Thread.currentThread().getName()+"------>Hello World!!");
    }
}
class MyRunnable1 implements Runnable{

    @Override
    public void run() {


        System.out.println(Thread.currentThread().getName()+"----------->begin");
        //睡眠1s
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"----------->"+i);
            try {
                //这里无法在方法种抛出异常,子类方法无法抛出更多的异常
                Thread.sleep(1000*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+"----------->over");

    }
}