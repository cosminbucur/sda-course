package com.bucur.homebank.export;

import com.bucur.homebank.model.Account;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface CustomFileWriter {

    //    String ACCOUNTS_DB = "/home/cosmin/Documents/dev/sda/java-advanced-code/src/main/resources/accounts-db.txt";
    String ACCOUNTS_DB = "C:\\dev\\sda\\sda\\java-advanced-code\\src\\main\\resources\\accounts-db.txt";
    Path path = Paths.get(ACCOUNTS_DB);

    void persist(Account account) throws IOException;
}
