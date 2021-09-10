package Day7_18;

public class Test04 {
    public static void main(String[] args) {
        Outer1  ou = new Outer1();
        ou.fun();
    }
}
class Outer1 {
    private String info = "nihao!";
    public Outer1(){

    }
    public void setInfo(String info){
        this.info = info;
    }
    public String getInfo(){
        return info;
    }
    public void fun(){
        Inner1 inner1 = new Inner1();
        inner1.print();
    }
}
class Inner1{
    Outer1 outer1 = new Outer1();
    public void print(){
        System.out.println(outer1.getInfo());
    }
}