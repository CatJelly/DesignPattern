import week2_assign.TicketManager;
import week2.Account;

public class Main {
    public static void main(String[] args) {
        Account acct1 = new Account("insang1", 1000000);
        acct1.deposit(20000);
        Account acct2 = new Account("insang2", 2000000);
        acct2.deposit(5000);
    }
}
