package Day5_12;

class Value {
    int v;
    public Value(int v) {
        this.v = v;
    }
}

public class FinalTest {

     final int f1 = 1;
     final int f2;
     public FinalTest() {
         f2 = 2;
    }
    public static void main(String[] args) {
         final int value1 = 1;
        // value1 = 4;
         final double value2;
         value2 = 2.0;
         final Value value3 = new Value(1);
         System.out.println(value3.v);
//         value3 = new Value(5);  //重新new一个对象再次赋值给value3就不行了
         value3.v = 4;
         System.out.println(value1);
         System.out.println(value2);
         System.out.println(value3.v);
     }
 }