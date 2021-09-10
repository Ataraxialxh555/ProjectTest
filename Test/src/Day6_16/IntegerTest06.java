package Day6_16;

public class IntegerTest06 {
    public static void main(String[] args) {
        // parseInt parseDouble parseFloat
        //parseInt 可以将字符串类型的整数转化为int类型的整数
        //parseInt 不可以将字串类类型的中文转化为int类型的整数
        // 会出现NumberFormatException异常
        // NumberFormatException
        int i = Integer.parseInt("123");
        System.out.println(i+1);
        double d = Double.parseDouble("5.223");
        System.out.println(d+2.3);
        float f = Float.parseFloat("1.3");
        System.out.println(f+2);

        // toBinaryString 十进制转为二进制  toHexString 十进制转为八进制 toOctalString  十进制转为十六进制
        // toBinaryString括号里面需要int类型
        String s = Integer.toBinaryString(5);
        System.out.println(s);

        String s1 = Integer.toOctalString(8);
        System.out.println(s1);

        String s2 = Integer.toHexString(17);
        System.out.println(s2);
        // 包装为Integer类
        Integer ii= Integer.valueOf(20);
        System.out.println(ii);
        String  iiii = String.valueOf(20);
    }
}
