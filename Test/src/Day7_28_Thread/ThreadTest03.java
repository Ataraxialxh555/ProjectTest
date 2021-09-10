package Day7_28_Thread;

public class ThreadTest03 {
    public static void main(String[] args) {
        Thread thread = new MyThread3();
        thread.setName("分支线程1");
        thread.start();

        try {
            //这段代码会使main线程睡眠2s  而不是使得分支线程睡眠2s

            thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"------------->"+"Hello World!!!");
    }
}
class MyThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"------------>"+i);
            try {
                //睡眠1s
                Thread.sleep(1000*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}