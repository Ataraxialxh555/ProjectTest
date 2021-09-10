package Day5_9;

public class Account {
    private int ano;
    private String name;
    private int balance;

    public Account() {
    }

    public Account(int ano, String name, int balance) {
        this.ano = ano;
        this.name = name;
        this.balance = balance;
    }

    public int getAno() {
        return ano;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
