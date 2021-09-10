import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6=b4+b5;
        b3= (byte) (b1+b2);
//        System.out.println(b3+b6);
        double x= 4;
        System.out.println(Math.sqrt(x));
        for (int i = 10; i > 0 ; i--) {
            System.out.println("Counting down ..."+i);
        }

        int[] arr = {22,2,3,5,6,8,65};
        int[] copyArr = Arrays.copyOf(arr,2*arr.length);
        for (int a:copyArr) {
            System.out.println(a);
        }
        System.out.println("=======================");
        Arrays.sort(copyArr);


        for (int b :copyArr) {
            System.out.println(b);
        }

        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate);
        int month = nowDate.getMonthValue();
        int year = nowDate.getYear();
        int today = nowDate.getDayOfMonth();
        System.out.println(month);
        System.out.println(year);
        System.out.println(today);

    }
}
