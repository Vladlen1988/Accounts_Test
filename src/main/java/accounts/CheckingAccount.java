package accounts;

import clients.Client;

public class CheckingAccount extends Account {

    public CheckingAccount(long balance, Client client) {
        super(balance, client);
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount < 0) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean transfer(Account accountTo, int amount) {
        boolean result = pay(amount);
        if (result) {
            if (accountTo.add(amount)) {
                System.out.println("Перевод выполнен успешно.");
                return true;
            } else {
                System.out.println("Перевод отклонен.");
                add(amount);
            }
        }
        return false;
    }

    @Override
    public boolean accept(int money) {
        return add(money);
    }
}
