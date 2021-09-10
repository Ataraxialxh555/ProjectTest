package Day6_20;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest01{
    public static void main(String[] args)  throws Exception{
        //打印当前时间 将Date类型 转换为 String类型
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSS");
        String s = sdf.format(nowTime);
        System.out.println(s);
        System.out.println("===========");
        //
        String ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nowTime);
        System.out.println(ss);
        System.out.println("============");
        // String类型 日期字符串 转换为Date类型
        String s1 = "1997-02-02  14:02:00.888";
        // String类型的日期字符串要和SimpleDateFormat中的日期格式要一致 空格的多少都要一样
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSS");
        Date myDate = sdf2.parse(s1);
        System.out.println(myDate);
        System.out.println("============");
        Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s1);
        System.out.println(d);

        }
}
