package Day6_20;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal(555555555);
        BigDecimal bigDecimal2 = new BigDecimal(666666666);
        BigDecimal bigDecimal3 = new BigDecimal(111111111);
        BigDecimal result  = bigDecimal1.add(bigDecimal2);
        System.out.println(result);
        BigDecimal result1 = bigDecimal1.divide(bigDecimal3);
        System.out.println(result1);
    }
}
