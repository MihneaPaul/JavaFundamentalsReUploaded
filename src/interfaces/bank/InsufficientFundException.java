package interfaces.bank;

/**
 * Created by Mihnea on 26.04.2017.
 */
public class InsufficientFundException extends Exception {
    public String toString() {
        return "Insufficient Funds";
    }
}
