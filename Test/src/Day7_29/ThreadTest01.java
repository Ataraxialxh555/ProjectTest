package Day7_29;

public class ThreadTest01 {
    public static void main(String[] args) {
        Thread thread = new BackupThread();
        thread.setName("BackupThread");
        //设置为守护线程
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"----->"+ i);

            try {
                //睡眠1s
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class BackupThread extends  Thread {
    @Override
    public void run() {
        int i = 0;
        //即使你是死循环，设置为守护线程后，用户线程结束了，守护线程也结束
        while(true){
            System.out.println(Thread.currentThread().getName()+"----->"+ ++i);
            try {
                // 睡眠1s
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}