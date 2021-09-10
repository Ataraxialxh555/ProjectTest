package FirstFeature;

public class InnerTest {

    public int outField1 = 1;
    protected int outField2 = 2;
    int outField3 = 3;
    private int outField4 = 4;

    public InnerTest() {
        // ���ⲿ������ڲ���ֱ��ͨ�� new InnerClass(); �����ڲ������
        InnerClassA innerObj = new InnerClassA();
        System.out.println("���� " + this.getClass().getSimpleName() + " ����");
        System.out.println("���ڲ���� field1 �ֶε�ֵΪ: " + innerObj.field1);
        System.out.println("���ڲ���� field2 �ֶε�ֵΪ: " + innerObj.field2);
        System.out.println("���ڲ���� field3 �ֶε�ֵΪ: " + innerObj.field3);
        System.out.println("���ڲ���� field4 �ֶε�ֵΪ: " + innerObj.field4);
    }

    public class InnerClassA {
        public int field1 = 5;
        protected int field2 = 6;
        int field3 = 7;
        private int field4 = 8;
//        static int field5 = 5; // ���������ͨ�ڲ����в��ܶ��� static ����

        public InnerClassA() {
            System.out.println("���� " + this.getClass().getSimpleName() + " ����");
            System.out.println("���ⲿ��� outField1 �ֶε�ֵΪ: " + outField1);
            System.out.println("���ⲿ��� outField2 �ֶε�ֵΪ: " + outField2);
            System.out.println("���ⲿ��� outField3 �ֶε�ֵΪ: " + outField3);
            System.out.println("���ⲿ��� outField4 �ֶε�ֵΪ: " + outField4);
        }
    }

    public static void main(String[] args) {
        InnerTest outerObj = new InnerTest();
        // �����ⲿ���ڲ���ʹ�ã��ⲿ�����. new �ڲ��๹����(); �ķ�ʽ�����ڲ������
//        InnerClassA innerObj = outerObj.new InnerClassA();
    }
}
