package Day6_20;

import java.util.Date;

public class DateTest02 {
    public static void main(String[] args) {
        //获取自1970年1月1日00：00：00 到当前系统时间的总毫秒数
        long nowTimeMillis = System.currentTimeMillis();
        System.out.println(nowTimeMillis);
        //获取一段循环程序跑的毫秒总数
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("耗时："+(time2 -time1)+"ms");
    }
}
