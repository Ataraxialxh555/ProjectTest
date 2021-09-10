package Day7_14;

public class Test1 {
    public static void main(String[] args) {

                for (int i = 1; i <= 10; i ++) {

                    if (i  == 5) {

                        break;  // 用来终止switch 或者离它最近的循环。

                    }
                    System.out.println("i  = "+i);
                }

                System.out.println("-----------------------");


                for (int i = 1; i <= 10; i ++) {

                    if (i  == 5) {

                        return;   // return;语句终止当前的方法，和break;不是一个级别的
                        // return 用来终止离它最近的一个方法（此处为main）

                    }
                    System.out.println("i  = "+i);

                }
                System.out.println("-----------------------");
        }
}

