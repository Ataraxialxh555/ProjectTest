package Day7_19;

public class InnerTest {
    private static class InnerClass{
        //静态内部类中的静态方法
        public static void m1(){
            System.out.println("静态内部类的静态方法m1方法执行了！！！！");
        }
        // 静态内部类中的实例方法
        public void m2(){
            System.out.println("静态内部类中的实例方法m2执行了！！！");
        }
    }

    public static void main(String[] args) {
        InnerTest.InnerClass.m1();
        // 创建静态内部类对象
        InnerTest.InnerClass ii = new InnerTest.InnerClass();
        ii.m2();
    }
}
