package Day5_11;

public class AbstractTest01 {
    public static void main(String[] args) {
        Account a = new BandAccount(); // 面向抽象编程！
        a.doSome();
    }
}
abstract class Account{
/*   abstract public void doOther(){
//        如果存在抽象类的方法，那么类必须是抽象类
    }
*/      private String name;
        private int age;
      abstract public void doSome();

    public Account() {
    }

    public Account(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class BandAccount extends Account{
    @Override
    public void doSome(){    //要重写父类的抽象方法。
        System.out.println("银行账户！！！");
    }
}