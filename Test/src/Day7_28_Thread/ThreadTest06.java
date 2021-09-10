package Day7_28_Thread;

public class ThreadTest06 {
    public static void main(String[] args) {
        MyRunnable2 my = new MyRunnable2();
        Thread thread  = new Thread(my);
        thread.start();
        try {
            thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        my.flag = false;
    }
}
class MyRunnable2 implements   Runnable{
    boolean flag = true;
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            if(flag){
                System.out.println(Thread.currentThread().getName()+"------>"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{

                return;
            }
        }
    }
}