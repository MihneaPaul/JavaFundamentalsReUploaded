package interfaces.bank;

/**
 * Created by Mihnea on 26.04.2017.
 */
public class FundLimitExceededException extends Exception {
    public String toString() {
        return "Fund limit has be exceeded.";
    }
}
