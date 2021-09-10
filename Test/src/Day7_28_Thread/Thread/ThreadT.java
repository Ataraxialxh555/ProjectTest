package Day7_28_Thread.Thread;

public class ThreadT {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(10000,"lixianghuan");
        Thread t1 = new AccountThread(ba);
        Thread t2 = new AccountThread(ba);
        t1.start();
        t2.start();


    }
}

class BankAccount{
    private int money;
    private String name;
    public BankAccount(){}
    public BankAccount(int money,String name){
        this.name = name;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "money=" + money +
                ", name='" + name + '\'' +
                '}';
    }

    public void  withdrawal(int money){
        synchronized (this){
            int before = this.getMoney();
            int after = before - money;
            //100%出问题 模拟网络延迟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setMoney(after);
        }
    }
}

class AccountThread  extends Thread{
    private BankAccount account;
    public AccountThread(){
    }
    public AccountThread(BankAccount account){
        this.account = account;
    }
    @Override
    public void run() {
        int money = 5000;
        account.withdrawal(money);
        System.out.println(Thread.currentThread(  ).getName()+"账号"+account.getName()+"取款5000成功，余额为"+account.getMoney());
    }
}