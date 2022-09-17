package clients;

import accounts.Account;
import accounts.MoneyTarget;

public class Client implements MoneyTarget {

    protected String name;
    protected int maxAccount;
    protected Account[] accounts;

    public Client(String name, int maxAccount) {
        this.name = name;
        this.maxAccount = maxAccount;
        accounts = new Account[maxAccount];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxAccount() {
        return maxAccount;
    }

    public void setMaxAccount(int maxAccount) {
        this.maxAccount = maxAccount;
    }

    public void add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Мест для добавления нового счёта нет! :(");
    }

    public boolean pay(int amount) {
        for (Account acc : accounts) {
            if (acc != null) {
                if (acc.pay(amount)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean accept(int money) {
        for (Account acc : accounts) {
            if (acc != null) {
                if (acc.accept(money)) {
                    System.out.println("Пополнение успешно на сумму " + money + " руб.");
                    return true;
                }
            }
        }
        System.out.println("Пополнение не возможно.");
        return false;
    }

}
