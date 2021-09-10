package Day6_20;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest03 {
    public static void main(String[] args) {
        Date time1 = new Date(900);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime  = sdf.format(time1);
        System.out.println(strTime);

        //获取昨天此时的时间
        long long1 = (long)1000*60*60*24*365;
        System.out.println(long1);
        Date time2 = new Date(System.currentTimeMillis()  - long1);
        String strTime2 = sdf.format(time2);
        System.out.println(strTime2);

    }
}
