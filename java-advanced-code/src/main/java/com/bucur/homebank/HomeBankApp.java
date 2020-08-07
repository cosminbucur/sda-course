package com.bucur.homebank;

import com.bucur.homebank.controller.MainController;
import com.bucur.homebank.export.CustomFileWriter;
import com.bucur.homebank.export.IoDataExporter;
import com.bucur.homebank.export.NioCustomFileWriter;
import com.bucur.homebank.repository.AccountRepository;
import com.bucur.homebank.ui.MenuBuilder;

import java.io.IOException;
import java.util.Scanner;

public class HomeBankApp {

    public static void main(String[] args) throws IOException {
        // create objects
        Scanner scanner = new Scanner(System.in);
        MenuBuilder menuBuilder = new MenuBuilder();

        CustomFileWriter customFileWriter = new NioCustomFileWriter();
        AccountRepository accountRepository = new AccountRepository(customFileWriter);

        IoDataExporter ioDataExporter = new IoDataExporter();

        MainController controller = new MainController(menuBuilder, scanner, accountRepository, ioDataExporter);

        // run program
        menuBuilder.displayMenu();
        int option = scanner.nextInt();
        controller.dispatch(option);

    }
}

