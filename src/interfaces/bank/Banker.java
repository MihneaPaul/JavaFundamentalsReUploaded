package interfaces.bank;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
/**
 * Created by Mihnea on 26.04.2017.
 */
public interface Banker {
    void withdraw(double amount) throws InsufficientFundException;
    void deposit(double amount)throws FundLimitExceededException;
//    default double getBalance() {
//        return 0;
//    }
}
class Bank implements Banker, Serializable {
    private int balance;

    public double getBalance() {
        System.out.println("Your balance is ");
        return balance;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundException {

            if (balance >= amount) {
                balance -= amount;
                System.out.println("You have successfully withdrawn $" + amount);
            }
            if (balance < 0) throw new InsufficientFundException();
    }

        @Override
        public void deposit (double amount) throws FundLimitExceededException {
//
            if (amount <= 2000) {
                balance += amount;
                System.out.println("You have deposited $" + amount);
            } else throw new FundLimitExceededException();

        }
}
class TestBank {
//    public static String finalBalance=null;

    public static void printMenu() {
        System.out.println("Welcome, costumer!");
        System.out.println("------------------");
        System.out.println("Please choose your desired option from the list below");

    }

    public static void main(String[] args) throws InsufficientFundException, FundLimitExceededException {
        int option;
        Bank b = new Bank();

        if (new File("C:\\Users\\Mihnea\\IdeaProjects\\JavaFundamentalsChapter16-17\\balance.log").isFile()) {
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream("C:\\Users\\Mihnea\\IdeaProjects\\JavaFundamentalsChapter16-17\\balance.log"));
                Object restoredBalance = os.readObject();
                Bank realBank = (Bank) restoredBalance;
                System.out.println("TEST");
                System.out.println("--------------");
                System.out.println(realBank.getBalance());
                System.out.println("--------------");
                System.out.println("END OF TEST");
                System.out.println("--------------\n");
//                os.close();

                printMenu();
                do {
                    System.out.println();
                    System.out.println("1 - View balance       2 - Deposit Money       3 - Withdraw money       0 - Exit");
                    System.out.println();
                    System.out.println("Enter option: ");
                    Scanner scanner = new Scanner(System.in);
                    option = scanner.nextInt();
                    if (option == 1) {
                        System.out.println(realBank.getBalance());

                    } else if (option == 2) {
                        System.out.println("----Fund limit is $2000----");
                        System.out.print("Enter amount to deposit: ");
                        int depositedAmount = scanner.nextInt();
                        realBank.deposit(depositedAmount);

                    } else if (option == 3) {
                        System.out.print("Enter amount to withdraw: ");
                        int withdrawAmount = scanner.nextInt();
                        realBank.withdraw(withdrawAmount);
                    }
                } while (option != 0);
                os.close();

                try {
                    ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Mihnea\\IdeaProjects\\JavaFundamentalsChapter16-17\\balance.log"));
                    os2.writeObject(b);
                    os2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//            b = null;
            } catch (IOException | ClassNotFoundException e) {
            }
        }
    }
}
