package Day5_15;

public class Test {
    public static void main(String[] args) {
        People p = new People();
        p = null;
        System.gc();
    }
}
class People{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("删除");
    }
}