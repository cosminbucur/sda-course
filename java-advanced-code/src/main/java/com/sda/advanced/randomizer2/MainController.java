package com.sda.advanced.randomizer2;

import java.util.Scanner;

public class MainController {

    private PersonRepository personRepository;
    private MainMenu mainMenu;
    private Scanner scanner;

    // dependency injection
    public MainController(PersonRepository personRepository, MainMenu mainMenu, Scanner scanner) {
        this.personRepository = personRepository;
        this.mainMenu = mainMenu;
        this.scanner = scanner;
    }

    // grab the user input and redirect to the appropriate object
    public void dispatch(int option) {
        while (option != 0) {
            switch (option) {
                case 1:
                    // if I decide to change the implementation of addPersons()
                    // I don't need to change the main controller
                    personRepository.addPersons();
                    break;
                case 2:
                    personRepository.selectNextPerson();
                    break;
                default:
                    System.out.println("choose one of the options");
            }
            // after selecting an option and running the logic, I want to display the menu again
            mainMenu.display();
            option = scanner.nextInt();
        }
    }
}
