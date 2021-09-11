package com.sda.advanced.homebank.export;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface DataExporter {

    default String getBackupFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String dateString = now.format(formatter);
        return "accounts-" + dateString + ".txt";
    }

    void createBackup() throws IOException;
    // read file to backup

    // create empty file with a custom name

    // write content of the initial file to the empty file
}
