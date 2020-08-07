package com.bucur.homebank.controller;

import com.bucur.homebank.export.IoDataExporter;
import com.bucur.homebank.repository.AccountRepository;
import com.bucur.homebank.ui.MenuBuilder;

import java.util.Scanner;

public class MainController {

    private MenuBuilder menuBuilder;
    private Scanner scanner;
    private AccountRepository accountRepository;
    private IoDataExporter ioDataExporter;

    public MainController(MenuBuilder menuBuilder, Scanner scanner, AccountRepository accountRepository, IoDataExporter ioDataExporter) {
        this.menuBuilder = menuBuilder;
        this.scanner = scanner;
        this.accountRepository = accountRepository;
        this.ioDataExporter = ioDataExporter;
    }

    public void dispatch(int option) {
        while (option != 0) {
            switch (option) {
                case 1:
                    accountRepository.createAccount();
                    break;
                case 2:
                    accountRepository.findAllAccounts();
                    break;
                case 3:
                    ioDataExporter.createBackup();
                    break;
                default:
                    System.out.println("Choose one of the displayed options!");
            }
            menuBuilder.displayMenu();
            option = scanner.nextInt();
        }
    }
}
