package Day7_28_Thread;

public class ThreadTest04 {
    public static void main(String[] args) {
        MyRunnable myRunnable= new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        // 睡眠5s
        try {
            thread.sleep(1000*5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        System.out.println(Thread.currentThread().getName()+"------>Hello World!!");
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {


            System.out.println(Thread.currentThread().getName()+"----------->begin");
            //睡眠1小时
            try {
                //这里无法在方法种抛出异常,子类方法无法抛出更多的异常
                Thread.sleep(1000*60*60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----------->over");

    }
}