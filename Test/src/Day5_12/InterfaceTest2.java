package Day5_12;

public class InterfaceTest2 {
    public static void main(String[] args) {
        Math m = new MyMath();
        int  res = m.sum(10,20);
        System.out.println(res);
        int res1 = m.sub(20,10);
        System.out.println(res1);
    }
}
interface Math{
    public static final double PI = 3.141592;

    public abstract int sum(int a ,int b);

    public abstract  int sub(int a ,int b );

}
class MyMath implements  Math{

    public int sum(int a ,int b ){
        return a+b;
    }
    public int sub (int a ,int b ){
        return a-b;
    }
}