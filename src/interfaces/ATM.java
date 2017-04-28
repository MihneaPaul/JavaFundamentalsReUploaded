package interfaces;

import javax.naming.InsufficientResourcesException;
import javax.security.auth.login.AccountNotFoundException;

/**
 * Created by Mihnea on 26.04.2017.
 */
public interface ATM {
    boolean login(int account) throws AccountNotFoundException;
    boolean deposit(double amount);
    boolean withdraw(double amount) throws InsufficientResourcesException;
    double getBalance();

    interface Card {
        String getNumber();
        String getSecurityCode();
        java.time.LocalDate getExpirationDate();
        String getCardHolderName();
    }
}
