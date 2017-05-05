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
    default String getBalance() {
        return "Current fund is " +getBalance();
    }
}
class Bank implements Banker {
    private int balance;


    public String getBalance() {
//        Path path = Paths.get("balance.log");
        try {
            FileInputStream fis = new FileInputStream("balance.log");
            ObjectInputStream ois = new ObjectInputStream(fis);

            int i = ois.readInt();
//        try {
//            List<String> data = Files.readAllLines(path, Charset.forName("UTF-16"));
//            for (String line : data) {
//                System.out.println(line);
//            }
////        return "Your current fund is $" + balance;
//        } catch (IOException e) {
//            System.out.println("I/O error " + e);
//        }
        }catch (IOException e){
            System.out.println(e);
        }
        return "Your balance is "+balance;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundException {
        try {
            FileOutputStream fos = new FileOutputStream("balance.log");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        Path path = Paths.get("balance.log");
//        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("balance.log"))) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("You have successfully withdrawn $" + amount);
                oos.writeObject(balance);
//                Files.write(Paths.get("balance.log"), balance, Charset.forName("UTF-8"));
//            System.out.println("Your current fund is $" + balance);
            }
            if (balance < 0) throw new InsufficientFundException();

//     else System.out.println("No money available.");

//        } catch (IOException e) {
//            System.out.println("I/O error " + e);
        }catch (IOException e){
            System.out.println(e);
        }
    }

        @Override
        public void deposit ( double amount) throws FundLimitExceededException {
//            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("balance.log"))) {
            try {
                FileOutputStream fos = new FileOutputStream("balance.log");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
            if (amount <= 2000) {
                balance += amount;
                System.out.println("You have deposited $" + amount);
                oos.write(balance);
//                System.out.println("Your current fund is $" + balance);
            } else throw new FundLimitExceededException();
        }catch (IOException e){
                System.out.println("I/O error "+e);
            }

    }

}
class TestBank {
    public static String finalBalance=null;

    public static void printMenu() {
        System.out.println("Welcome, costumer!");
        System.out.println("------------------");
        System.out.println("Please choose your desired option from the list below");

    }
    public static void main(String[] args) throws InsufficientFundException, FundLimitExceededException {
        int option;
        Banker b = new Bank();
        printMenu();
        do {
            System.out.println();
            System.out.println("1 - View balance       2 - Deposit Money       3 - Withdraw money       0 - Exit");
            System.out.println();
            System.out.println("Enter option: ");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        if(option==1) {
            System.out.println(b.getBalance());

        }
        else if(option==2) {
            System.out.println("----Fund limit is $2000----");
            System.out.print("Enter amount to deposit: ");
            int depositedAmount = scanner.nextInt();
            b.deposit(depositedAmount);
            finalBalance=b.getBalance();
        }
        else if(option==3) {
            System.out.print("Enter amount to withdraw: ");
            int withdrawAmount = scanner.nextInt();
            b.withdraw(withdrawAmount);
            finalBalance=b.getBalance();
        }
    }while(option!=0);

//        b.deposit(30);
//        b.withdraw(30);
//        b.deposit(500);
//        b.deposit(1999);
//        b.deposit(2000);
////        b.deposit(2001);
//        b.getBalance();
}
}
