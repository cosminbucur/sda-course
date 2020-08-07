package com.bucur.homebank.repository;

import com.bucur.homebank.export.CustomFileWriter;
import com.bucur.homebank.model.Account;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountRepository {

    private static List<Account> accounts = new ArrayList<>();
    private CustomFileWriter customFileWriter;

    public AccountRepository(CustomFileWriter customFileWriter) {
        this.customFileWriter = customFileWriter;
    }

    public void createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Specify the owner name: ");
        String owner = scanner.nextLine();

        System.out.print("Specify how much money he wants to deposit: ");
        BigDecimal balance = scanner.nextBigDecimal();

        try {
            Account account = new Account(owner, balance);

            // save to db
            customFileWriter.persist(account);

            accounts.add(account);
            System.out.println("info: Account created: " + account);
        } catch (IOException e) {
            System.out.println("error: Failed to persist account.");
        }
    }

    public void findAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("info: No accounts found");
        }

        accounts.forEach(account -> System.out.println(account));
    }

    public void updateAccount(Account account) {

    }

    public void deleteAccount(Account account) {

    }
}
