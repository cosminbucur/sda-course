package com.sda.advanced.homebank.load;

import com.sda.advanced.homebank.model.Account;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class NioFileReader implements DataLoader {

    @Override
    public List<Account> loadData() throws IOException {
        List<String> accountLines = Files.readAllLines(path);
        List<Account> accounts = new ArrayList<>();

        for (String accountsLine : accountLines) {
            System.out.println(accountsLine);

            // split line by columns split by comma
            String[] accountInfo = accountsLine.split(",");

            // extract values from array
            String owner = accountInfo[0];
            BigDecimal balance = new BigDecimal(accountInfo[1]);

            // instantiate account
            Account account = new Account(owner, balance);
            accounts.add(account);
        }
        return accounts;
    }
}
