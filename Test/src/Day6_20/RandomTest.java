package Day6_20;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        //创建一个随机数
        Random randomNumber = new Random();
        //调用随机数的方法，随机产生一个int类型的数字
        int num = randomNumber.nextInt();
        System.out.println(num);
        // nextInt(bound) bound为界限 若bound=101；则表示随机数在【0，100】之间产生
        // 不包括101
        int num1 = randomNumber.nextInt(101);
        System.out.println(num1);
    }
}
