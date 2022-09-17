package accounts;

import clients.Client;

public class SavingsAccount extends Account {
    long minBalace;

    public SavingsAccount(long balance, Client client) {
        super(balance, client);
        this.minBalace = 1000;
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount < minBalace) {
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
