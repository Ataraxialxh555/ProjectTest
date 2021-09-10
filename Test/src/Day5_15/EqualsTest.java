package Day5_15;

public class EqualsTest {
    public static void main(String[] args) {
        MyTime t1 = new MyTime(2021,2,2);
        MyTime t2 = new MyTime(2021,2,2);

        boolean result = t1.equals(t2);
        System.out.println(result);

//        int result1 = t1.hashCode();
//        System.out.println(result1);
    }
}
