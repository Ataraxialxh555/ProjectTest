package Day8_15;

public class ShuiXianHuaShu {
    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            int x = i / 100;  // ��λ
            int y = i / 10 % 10; //ʮλ
            int z = i % 10;  //��λ
            if (i == (x * x * x) + (y * y * y) + (z * z * z)) {
                System.out.println("ˮ�ɻ�����" + i);
            }
        }
    }
}
