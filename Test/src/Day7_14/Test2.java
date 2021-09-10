package Day7_14;

public class Test2 {
            static int  i = 100;
            static {

                System.out.println("i = " +i);
            }
            static String name ="zhongguo";
            static {

                System.out.println("name = "+name);
            }

            {
                System.out.println("实例代码块！");
                // 只要构造方法执行，实例语句块肯定执行；构造方法执行一次，实例语句块肯定执行一次
            }
            public static void main(String [] args) {
                System.out.println("main begin");
                new Test2();
                new Test2(100);
            }

            public Test2() {
                System.out.println("无参数构造方法执行了！");
            }
            public Test2(int i) {
                System.out.println("有参数构造方法执行了！"); }
    }

