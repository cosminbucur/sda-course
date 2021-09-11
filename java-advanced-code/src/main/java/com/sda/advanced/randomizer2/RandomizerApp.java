package com.sda.advanced.randomizer2;

import java.util.Scanner;

public class RandomizerApp {


    public static void main(String[] args) {
        // create app objects
        MainMenu mainMenu = new MainMenu();
        Scanner scanner = new Scanner(System.in);
        PersonRepository personRepository = new PersonRepository();
        MainController mainController = new MainController(personRepository, mainMenu, scanner);

        // usage
        mainMenu.display();

        // read option from user
        int option = scanner.nextInt();

        // redirect option to the appropriate object
        mainController.dispatch(option);
    }


}
