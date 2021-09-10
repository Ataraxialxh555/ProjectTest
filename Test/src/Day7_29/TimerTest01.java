package Day7_29;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest01 {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2021-7-29 10:20:00");
        timer.schedule(new TimerTask() {
            //匿名内部类
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String s = sdf.format(date);
                System.out.println(s+"进行了数据的备份！！！");
            }
        }, firstTime, 1000 * 5);
    }
}
