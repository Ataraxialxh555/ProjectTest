package Day6_16;

public class IntegerTest05 {
    public static void main(String[] args) {
        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2); //false
        Integer a = 126;
        Integer b = 126;
        // 在内加载的时候，[-128 127]在方法区中存在，整数型常量池中已经提前存储了，
        // 缓存机制，所以在堆中不用去new对象，
        // 在栈中main方法中创建的a、b直接指向整数型常量池中的126
        System.out.println(a == b); //true
    }
}
