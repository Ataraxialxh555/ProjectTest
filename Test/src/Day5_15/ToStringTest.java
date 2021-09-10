package Day5_15;

import java.util.Objects;

public class ToStringTest {
    public static void main(String[] args) {
        MyTime time1 = new MyTime(2021,2,2);
        MyTime time2 = new MyTime(2020,5,5);
        String res1 = time1.toString();
        String res2 = time2.toString();
        System.out.println(res1);
        System.out.println(res2);
    }
}
class MyTime{
    private int year;
    private int month;
    private int day;

    public MyTime() {
    }

    public MyTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

  @Override   //重写toString()方法
  public String toString() {
        return "MyTime{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
    @Override   //重写equals方法
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTime myTime = (MyTime) o;
        return year == myTime.year && month == myTime.month && day == myTime.day;
    }

   @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }


}