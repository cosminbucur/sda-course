package com.sda.advanced.homebank.export;

import java.io.*;

public class BufferedDataExporter implements DataExporter {

    public static final String BACkUP_FOLDER = "C:\\dev\\sda\\sda\\java-advanced-code\\src\\main\\resources\\accounts-db.txt";

    @Override
    public void createBackup() {
        String fileName = getBackupFileName();
        File file = new File(BACkUP_FOLDER + "\\" + fileName);

        // read file to backup
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\" + fileName));

            String contentLine = br.readLine();
            while (contentLine != null) {
                System.out.println(contentLine);
                contentLine = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error in closing the BufferedReader");
                }
            }
        }
    }


}
