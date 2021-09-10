import java.util.function.Consumer;
/*
* Lambda表达式需要一个参数，但是没有返回值
* 数据类型可以省略Lambda表达式
* Lambda表达式只有一个参数的时候，参数的小括号也可以省略
*
* */
public class LambdaTest02 {
    public static void main(String[] args) {
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        c.accept("我爱中国！");


        System.out.println("==================");
        Consumer<String> c1 = (s)-> System.out.println(s); ;
        c.accept("我爱中国！");

        System.out.println("==============");
        System.out.println("==================");
        //参数的小括号可以省略，参数列表只有一个时
        Consumer<String> c2 = s-> System.out.println(s); ;
        c.accept("我爱中国！");
    }
}
