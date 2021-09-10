package Day5_15;

public class Test3 {
    public static void main(String[] args) {
        MyMath mm = new MyMath();
//        匿名内部类
        mm.mySum(new Compute() {
            @Override
            public int sum(int x, int y) {
                return x+y;
            }
        }, 100, 200);

    }
}
