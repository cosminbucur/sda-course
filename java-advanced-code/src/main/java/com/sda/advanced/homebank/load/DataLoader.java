package com.sda.advanced.homebank.load;

import com.sda.advanced.homebank.export.CustomFileWriter;
import com.sda.advanced.homebank.model.Account;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public interface DataLoader {

    String ACCOUNTS_DB = "accounts-db.txt";
    Path path = Paths.get(CustomFileWriter.ACCOUNTS_DB);

    List<Account> loadData() throws IOException;
}
