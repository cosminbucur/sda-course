package com.bucur.homebank.export;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoDataExporter implements DataExporter {

    @Override
    public void createBackup() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            // read the file that will be backed up
            fileInputStream = new FileInputStream(CustomFileWriter.ACCOUNTS_DB);

            // add timestamp to the backup file name
            String backupFilename = getBackupFileName();

            // use the new name to create a new file
            fileOutputStream = new FileOutputStream(backupFilename);

            // TODO: Fix this
            int data = fileInputStream.read();

            // read every byte till the end of the file
            do {
                fileOutputStream.write(data);
                // read next byte from the source
                data = fileInputStream.read();
            } while (data != -1);   // if file is at the end, read() returns -1

            // close both streams to release the resources

            fileInputStream.close();
            fileOutputStream.close();

            System.out.println("Backup complete at: " + backupFilename);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } finally {

        }
    }
}
