import java.time.DayOfWeek;
import java.time.LocalDate;


 class CalendarTest {

    public static void main(String[] args) {
        //获取当前的月和日
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        //将date设置为这个月的第一天
        date = date.minusDays(today - 1);
        //得到这一天为星期几 Monday...Sunday
        DayOfWeek weekday = date.getDayOfWeek();
        //获取星期几所对应的数字  1 = Monday  .... 7=Sunday
        int value = weekday.getValue();
        //打印表头和第一行
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < value; i++) {
            System.out.print("   ");
        }
        while (date.getMonthValue() == month){
            System.out.printf("%3d",date.getDayOfMonth());
            if(date.getDayOfMonth() == today){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
            date =date.plusDays(1);
            if (date.getDayOfWeek().getValue() ==1)
            {
                System.out.println();
            }
        }
        if (date.getDayOfWeek().getValue() != 1){
            System.out.println();
        }
    }

    /**
     * 方法注释
     * @param s
     */
    public void doSome(String s){
        System.out.println(s);
    }
}
