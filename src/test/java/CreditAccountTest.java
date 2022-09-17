import accounts.CreditAccount;
import clients.Client;
import org.junit.jupiter.api.*;

@DisplayName("Тестирование класса CreditAccount")

public class CreditAccountTest {
    private Client client = new Client("Алексей", 5);

    private CreditAccount creditAccount = new CreditAccount(client);

    @Test
    @DisplayName("Тестирование метода add")
    void add() {
        creditAccount.setBalance(-100);
        Assertions.assertEquals(true, creditAccount.add(100));
        Assertions.assertEquals(false, creditAccount.add(200));
    }
}
