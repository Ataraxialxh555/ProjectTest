package Day7_28_Thread;

public class ThreadTest07 {
    public static void main(String[] args) {
        /*System.out.println("最大优先级别:"+Thread.MAX_PRIORITY);
        System.out.println("最小优先级别:"+Thread.MIN_PRIORITY);
        System.out.println("默认优先级别:"+Thread.NORM_PRIORITY);*/
        //设置主线程的优先级别 1
        Thread.currentThread().setPriority(1);

        System.out.println(Thread.currentThread().getName()+"线程的默认优先级别"+Thread.currentThread().getPriority());
        Thread thread = new Thread(new MyRunnable3());
        thread.setName("T");
        //设置线程优先级别
        thread.setPriority(10);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"=------------->"+i);
        }
    }
}
class MyRunnable3 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程的优先级别:"+Thread.currentThread().getPriority());
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"=------------->"+i);
        }
    }
}