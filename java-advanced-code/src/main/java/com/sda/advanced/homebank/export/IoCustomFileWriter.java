package com.sda.advanced.homebank.export;

import com.sda.advanced.homebank.model.Account;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoCustomFileWriter implements CustomFileWriter {

    @Override
    public void persist(Account account) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(ACCOUNTS_DB, true);

            String accountString = account.getOwner() + ", " + account.getBalance() + "\n";
            System.out.println(accountString);

            fos.write(accountString.getBytes());

        } catch (FileNotFoundException e) {
            System.out.println("I didn't find the file. Exiting...");
        } catch (IOException e) {
            System.out.println("I failed to write to the file");
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("I failed to close the stream!");
            }
        }
    }
}
