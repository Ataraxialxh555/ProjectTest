package Day7_21_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
记录日志方法
*/
public class Logger {
    public static void log(String msg){
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("LogFile.txt",true));
            System.setOut(ps);
            Date  date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strTime =  sdf.format(date);
            ps.println(strTime+":"+msg);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
