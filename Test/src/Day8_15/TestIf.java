package Day8_15;

import java.util.Scanner;

public class TestIf {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("�����뿼���ɼ���");
        int i = s.nextInt();
        if (i >= 0 && i < 60) {
            System.out.println("������");
        } else if (i < 70) {
            System.out.println("����");
        } else if (i < 80) {
            System.out.println("����");
        } else if (i < 90) {
            System.out.println("��");
        } else if (i <= 100) {
            System.out.println("����");
        } else {
            System.out.println("�Ƿ��ɼ�");
        }

    }
}
