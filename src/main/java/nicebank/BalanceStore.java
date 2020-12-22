package nicebank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class BalanceStore {
    private static String BALANCE_FILE_PATH = "./balance";

    public static void clear() {
        new File(BALANCE_FILE_PATH).delete();
        //this.currency = Currency.getInstance(Locale.UK);
        setBalance(new Money(0,0));
    }

    public static Money getBalance() {
        File balanceFile = new File(BALANCE_FILE_PATH);
        Scanner scanner = null;
        try {
            scanner = new Scanner(balanceFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Probably need regex here
        Money balance = new Money(scanner.nextLine());
        scanner.close();

        return balance;
    }

    public static void setBalance(Money newBalance){

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(BALANCE_FILE_PATH, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(newBalance);
        writer.close();
    }
}
