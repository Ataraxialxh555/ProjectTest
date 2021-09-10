package Day7_28_Thread;

public class ThreadTest02 {
    public static void main(String[] args) {
        Thread thread = new MyThread2();
        thread.setName("分支线程1");
        System.out.println(thread.getName());
        thread.start();
        //获取优先级
//        int res = thread.getPriority();
//        System.out.println(res);
        for (int i = 0; i < 100; i++) {
//            Thread currentT = Thread.currentThread();
//            System.out.println(currentT.getName()+"-------------->"+i);
            System.out.println(Thread.currentThread().getName()+"-------------->"+i);
        }
    }
}
class MyThread2 extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //Thread.currentThread().getName() 得到当前线程的名字
//            Thread currentThread = Thread.currentThread();
//            System.out.println(currentThread.getName()+"----------->"+i);
            System.out.println(Thread.currentThread().getName()+"----------->"+i);
        }
    }
}