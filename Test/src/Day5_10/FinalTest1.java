package Day5_10;

public class FinalTest1 {
    public static void main(String[] args) {
        A a = new A();
        a.move();
    }
}

class A{
    public final void move(){
        System.out.println("移动！！！！！");
    }
}
class B extends  A{
//    'move()' 无法重写 'Day5_10.A' 中的 'move()'；重写的方法为 final
  /*
    public void move(){
        System.out.println("tiaotiaotiao!!!");
    }
   */
}