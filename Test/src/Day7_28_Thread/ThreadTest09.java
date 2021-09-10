package Day7_28_Thread;

public class ThreadTest09 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Day7_28_Thread.MyRunnable4());
        thread.setName("A");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----->" + i);
        }
    }

    class MyRunnable4 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {

                System.out.println(Thread.currentThread().getName() + "------>" + i);
            }
        }
    }

}
