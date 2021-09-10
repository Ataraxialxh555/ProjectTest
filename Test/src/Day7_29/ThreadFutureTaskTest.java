package Day7_29;

import javax.swing.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadFutureTaskTest {
    public static void main(String[] args) throws Exception{
        FutureTask ft = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"----->futuretask begin");
                Thread.sleep(1000*5);
                System.out.println(Thread.currentThread().getName()+"----->futuretask over");
                int a = 100;
                int b = 200;
                return a+b;
            }
        });
        Thread thread = new Thread(ft);
        thread.start();

        Integer integer = (Integer)ft.get();
        System.out.println(Thread.currentThread().getName()+"--------->"+integer);

        System.out.println(Thread.currentThread().getName()+"------>hello world!");
    }
}
