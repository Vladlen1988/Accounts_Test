import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import clients.Client;
import org.junit.jupiter.api.*;

@DisplayName("Тестирование класса CheckingAccount")

public class CheckingAccountTest {
    private Client client = new Client("Алена", 5);
    private CheckingAccount checkingAccount = new CheckingAccount(2000, client);

    @Test
    @DisplayName("Тестирование метода pay")
    void pay() {
        Assertions.assertEquals(true, checkingAccount.pay(1000));
        Assertions.assertEquals(false, checkingAccount.pay(2000));
    }

    @Test
    @DisplayName("Тестирование метода add")
    void add() {
        Assertions.assertEquals(true, checkingAccount.add(100));
    }

    @Test
    @DisplayName("Тестирование метода transfer")
    void transfer() {
        Assertions.assertEquals(false, checkingAccount.transfer(new CreditAccount(client), 1000));
        Assertions.assertEquals(true, checkingAccount.transfer(new SavingsAccount(100, client), 100));
    }
}
