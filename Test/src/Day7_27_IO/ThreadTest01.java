package Day7_27_IO;

public class ThreadTest01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
//        myThread.run(); //不会启动分支线程
        //start()方法的作用：启动一个分支线程，在jvm上开辟一个新的栈空间，瞬间结束这段代码
        //启动分支线程成功后会自动调用run()方法
        myThread.start();

        for (int i = 0; i < 1000; i++){
            System.out.println("主线程------->"+i);
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程---------->"+i);
        }
    }

}