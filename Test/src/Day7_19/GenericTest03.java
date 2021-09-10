package Day7_19;

public class GenericTest03<E> {
    public void doSome(E e){
        System.out.println(e);
    }
    public static void main(String[] args) {
        // 指定泛型的具体类型是String类型
        GenericTest03<String> g = new GenericTest03<>();
        g.doSome("abc");// doSome方法中传入的参数类型就必须是String类型
    }
}
