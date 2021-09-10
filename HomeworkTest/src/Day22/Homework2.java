package Day22;
/*
        利用接口做参数，写个计算器，能完成加减乘除运算。
        （1）定义一个接口Compute含有一个方法int computer(int n, int m)。
        （2）设计四个类分别实现此接口，完成加、减、乘、除运算。
        （3）设计一个类UseCompute，类中含有方法：
        public void useCom(Compute com, int one, int two)，
        此方法能够用传递过来的对象调用computer方法完成运算，并输出运算的结果。
        （4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。


 */
public class Homework2 {
    public static void main(String[] args) {
        Compute c1 = new Add();
        Compute c2 = new Sub();
        Compute c3 = new Multiply();
        Compute c4 = new Divide();


        UseCompute uc = new UseCompute();
        //加
        uc.useCom(c1,10,20);
        //减
        uc.useCom(c2,20,10);
        //乘
        uc.useCom(c3,50,2);
        //除
        uc.useCom(c4,50,5);
    }
}
class Add implements Compute{
    @Override
    public int computer(int n, int m) {
        return n+m;
    }
}
class Sub implements Compute{
    @Override
    public int computer(int n, int m) {
        return n-m;
    }
}
class Multiply implements Compute{
    @Override
    public int computer(int n, int m) {
        return n*m;
    }
}
class Divide implements Compute{
    @Override
    public int computer(int n, int m) {
        return n/m;
    }
}
class UseCompute {
    public UseCompute(){}
    public void useCom(Compute c,int one ,int two){
        int result = c.computer(one,two);
        if (c instanceof Add){
            System.out.println(one + "+"+two +"="+result);
        }else if (c instanceof Sub){
            System.out.println(one + "-"+two +"="+result);
        }else if (c instanceof Multiply){
            System.out.println(one + "*"+two +"="+result);
        }else if (c instanceof Divide){
            System.out.println(one + "/"+two +"="+result);
        }
    }
}
interface Compute {
    public abstract int computer(int n ,int m);
}