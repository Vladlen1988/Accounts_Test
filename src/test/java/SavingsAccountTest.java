import accounts.SavingsAccount;
import clients.Client;
import org.junit.jupiter.api.*;

@DisplayName("Тестирование класса SavingsAccount")

public class SavingsAccountTest {

    private SavingsAccount savingsAccount = new SavingsAccount(2000, new Client("Александр", 5));

    @Test
    @DisplayName("Тестирование метода pay")
    void pay() {
        Assertions.assertEquals(true, savingsAccount.pay(500));
        Assertions.assertEquals(false, savingsAccount.pay(1000));
    }
}
