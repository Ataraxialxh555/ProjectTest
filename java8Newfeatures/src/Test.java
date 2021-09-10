import javax.print.CancelablePrintJob;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love Java!");
            }
        };
        r1.run();
        System.out.println("========================");
        // Java8新特性   Lambda表达式
        Runnable r2 = () -> {System.out.println(" I love Java!");};
        r2.run();


        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = c.compare(12, 23);
        System.out.println(compare1);
        System.out.println("=================");
        Comparator<Integer> c1 = (o1, o2) -> Integer.compare(o1, o2);

        int compare2 = c1.compare(244, 23);
        System.out.println(compare2);
        System.out.println("=========");
        //方法引用

        Comparator<Integer> comparator = Integer :: compare;
        int compare3 = comparator.compare(122,323);
        System.out.println(compare3);

    }
}
