package accounts;

import clients.Client;

public class CreditAccount extends Account {

    public CreditAccount(Client client) {
        super(client);
    }

    @Override
    public void setBalance(long balance) {
        if (balance <= 0) {
            this.balance = balance;
        } else {
            System.out.println("Баланс не может быть положительным.");
        }
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        return true;
    }

    @Override
    public boolean add(long amount) {
        if (balance + amount <= 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
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