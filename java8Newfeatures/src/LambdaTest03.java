import java.util.Comparator;

/*
 * Lambda需要两个或者以上的参数，多条执行语句，并且可以有返回值
 * 大部分Lambda体只有一条语句时，return与大括号若有，都可以省略
 * */
public class LambdaTest03 {
    public static void main(String[] args) {
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int result = c1.compare(12, 30);
        System.out.println(result);


        System.out.println("================");
        Comparator<Integer> c2 = (o1, o2) -> o1.compareTo(o2);
        int result1 = c2.compare(12, 2);
        System.out.println(result1);


        System.out.println("================");
        Comparator<Integer> c3 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        int result2 = c3.compare(12, 2);
        System.out.println(result2);

    }
}
