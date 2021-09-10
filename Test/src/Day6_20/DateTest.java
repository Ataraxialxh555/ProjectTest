package Day6_20;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss  SSS'ms'");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String s = sdf.format(date);
        String s1 = sdf1.format(date);
        System.out.println(s);
        System.out.println(s1);

    }
}
