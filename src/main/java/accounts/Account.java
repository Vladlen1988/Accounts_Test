package accounts;

import clients.Client;

public abstract class Account implements MoneyTarget {
    protected long balance;
    Client client;

    public Account(long balance, Client client) {
        this.balance = balance;
        this.client = client;
    }

    public Account(Client client) {
        this.client = client;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public abstract boolean pay(long amount);

    public abstract boolean add(long amount);

    public abstract boolean transfer(Account accountTo, int amount);
}