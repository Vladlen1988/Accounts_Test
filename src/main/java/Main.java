import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import clients.Client;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        Client clientOne = new Client("Алёна", 5);

        SavingsAccount savingsAccount = new SavingsAccount(2000, clientOne);
        CheckingAccount checkingAccount = new CheckingAccount(1000, clientOne);
        CreditAccount creditAccount = new CreditAccount(clientOne);

        clientOne.add(savingsAccount);
        clientOne.add(checkingAccount);
        clientOne.add(creditAccount);

        savingsAccount.transfer(checkingAccount, 500);
        System.out.println("Баланс накопительного счета " + savingsAccount.getBalance() + " руб.");
        System.out.println("Баланс расчетного счета " + checkingAccount.getBalance() + " руб.");

        System.out.println();

        checkingAccount.transfer(creditAccount, 100);

        System.out.println();

        clientOne.accept(500);

    }
}
