public class Calculator {
    public int add(int x, int y) { //�ӷ�
        return x + y;
    }

    public int sub(int x, int y) { //����
        return x - y;
    }

    public int mul(int x, int y) { //�˷�
        return x * y;
    }

    public int div(int x, int y) { //����
        return x / y;
    }

    public int div2(int x, int y) { //����  �����쳣�ж�
        try {
            int z = x / y;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x / y;
    }

    public void loop(int x, int y) { //��ѭ��
        for (; ; )
            x = y;
    }

    public void unCompleted(int x, int y) {
        //δ��ɵ�ģ��:����ƽ���������ȵ�
        //���ڿ�����
    }


//    public static void main(String[] args) { // ��ͳ�������
//        int a = 8;
//        int b = 2;
//        Calculator calculator = new Calculator();
//        System.out.println(calculator.add(a, b));
//        System.out.println(calculator.sub(a, b));
//        System.out.println(calculator.mul(a, b));
//        System.out.println(calculator.div(a, b));
//        System.out.println(calculator.div2(a,0));
//    }
}