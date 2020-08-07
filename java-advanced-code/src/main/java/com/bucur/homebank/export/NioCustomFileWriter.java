package com.bucur.homebank.export;

import com.bucur.homebank.model.Account;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class NioCustomFileWriter implements CustomFileWriter {

    @Override
    public void persist(Account account) throws IOException {
        // serialize object (transform to string)
        String accountString = account.getOwner() + ", " + account.getBalance() + "\n";

        // write string to file, by appending (not replacing)
        Files.write(CustomFileWriter.path, accountString.getBytes(), StandardOpenOption.APPEND);
        System.out.println("Account persisted as: " + accountString);
    }
}
