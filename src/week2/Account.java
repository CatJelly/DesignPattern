package week2;

public class Account {
    private String owner;
    private int balance;
    private Logger_EagerInit myLogger;

    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
        this.myLogger = Logger_EagerInit.getInstance();
    }

    public String getOwner() { return owner; }
    public int getBalance() { return balance; }

    public void deposit(int money) {
        myLogger.log("owner" + " : " + this.getOwner() + " deposit " + money);
        balance += money;
    }
    public void withdraw(int money) {
        myLogger.log("owner" + " : " + this.getOwner() + " withdraw " + money);
        balance -= money;
    }
}
