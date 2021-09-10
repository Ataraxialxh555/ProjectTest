package Day6_20;

import java.text.DecimalFormat;

public class DecimalFormatTest {
    public static void main(String[] args) {
        // DecimalFormat数字格式化
        // # 代表任意数字
        // , 代表千分位
        // . 代表小数点
        // 0 不够的时候补0
        DecimalFormat  df = new DecimalFormat("####,###.###");
        String s = df.format(25153.125);
        System.out.println(s);

        System.out.println("=====================");
        DecimalFormat df2 = new DecimalFormat("######,###.00000");
        String s1 = df2.format(33333.1);
        System.out.println(s1);
    }
}
