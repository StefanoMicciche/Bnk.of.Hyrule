import org.example.Account;
import org.example.currentAccount;
import org.example.savingAccount;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Differents type of accounts")
public class accountTest {

    @Test
    public void testAccount() {
        savingAccount savingAccount = new savingAccount(11000.0, 3.0);

        assertAll(
                () -> assertTrue(savingAccount.isActive()),
                () -> assertTrue(savingAccount.deposit(1000.0)),
                () -> assertEquals(12000.0, savingAccount.getBalance(), 0.01)
        );
    }

    @Test
    public void testInactiveSavingsAccount() {
        savingAccount savingsAccount = new savingAccount(5000.0, 3.0);

        assertAll(
                () -> assertFalse(savingAccount.isActive(), "Cuenta debe estar inactiva"),
                () -> assertFalse(savingAccount.deposit(1000.0), "Depósito no debe ser permitido"),
                () -> assertEquals(5000.0, savingAccount.getBalance(), 0.01, "Saldo no debe cambiar")
        );
    }

}