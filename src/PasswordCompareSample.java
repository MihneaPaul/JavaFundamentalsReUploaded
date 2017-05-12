import java.io.*;

import java.util.*;
/**
 * Created by Mihnea on 03.05.2017.
 */
public class PasswordCompareSample {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Console console =System.console();
        if(console==null) {
            throw new RuntimeException("Console not available");
        }else {
            char[]password = console.readPassword("Enter password: ");
            console.format("Enter your password again: ");
            console.flush();
            char[] verify = console.readPassword();
            boolean match = Arrays.equals(password, verify);

            // Immediately clear passwords from memory
            for(int i=0;i<password.length;i++) {
                password[i]='x';
            }
            for(int i=0;i<verify.length;i++) {
                verify[i]='x';
            }
            console.format("Your password was "+(match?"correct":"incorrect"));
        }
    }
}
