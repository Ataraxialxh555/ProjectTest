package Day8_15;

public class ShuiXianHuaShu {
    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            int x = i / 100;  // 百位
            int y = i / 10 % 10; //十位
            int z = i % 10;  //个位
            if (i == (x * x * x) + (y * y * y) + (z * z * z)) {
                System.out.println("水仙花数：" + i);
            }
        }
    }
}
