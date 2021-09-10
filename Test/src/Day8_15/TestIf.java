package Day8_15;

import java.util.Scanner;

public class TestIf {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入考生成绩：");
        int i = s.nextInt();
        if (i >= 0 && i < 60) {
            System.out.println("不及格");
        } else if (i < 70) {
            System.out.println("及格");
        } else if (i < 80) {
            System.out.println("良好");
        } else if (i < 90) {
            System.out.println("好");
        } else if (i <= 100) {
            System.out.println("优秀");
        } else {
            System.out.println("非法成绩");
        }

    }
}
