package Day7_17;

import jdk.swing.interop.SwingInterOpUtils;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("不传递参数：");
        doSome();
        System.out.println("传递一个参数：");
        doSome(1);
    }
    public static void doSome(int... arg){
        for (int i = 0; i < arg.length; i++) {
            System.out.println(arg[i]+"、");
        }
    }
}
