package Day7_18;

public class Test03 {
    public static void main(String[] args) {
        Other o1 = null;
        o1 = Other.getOther();   //使用类名.属性访问静态属性
        o1.print();
        new Outer().fun();

    }
}

class Other{
    private static Other other = new Other();  //在内部产生本类的实例化对象
    private Other(){  //将构造方法进行封装

    }
    public void print(){
        System.out.println("Hello World!!!");
    }
    public static Other getOther(){
        return other;
    }
    public void setOther(Other other){
        this.other = other;
    }
}

class Outer{
    private String info ="Hello World!";
    class Inner{
        public void print(){
            System.out.println(info);
        }
    }
    public void fun(){
       new Inner().print();
    }
}