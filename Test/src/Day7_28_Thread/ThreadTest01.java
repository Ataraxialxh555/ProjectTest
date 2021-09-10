package Day7_28_Thread;

public class ThreadTest01 {
    public static void main(String[] args) {
        Thread thread  = new MyThread1();
        System.out.println(thread.getName());  //Thread-0默认线程名字

        thread.setName("分支线程1");
        System.out.println(thread.getName());

        Thread thread1  = new MyThread1();
        System.out.println(thread1.getName()); //默认线程名字Thread-1

        thread1.setName("分支线程2");
        System.out.println(thread1.getName());

        for (int i = 0; i < 100; i++) {
            System.out.println("主线程-------------->"+i);
        }
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("分支线程----------->" + i);
        }
    }
}