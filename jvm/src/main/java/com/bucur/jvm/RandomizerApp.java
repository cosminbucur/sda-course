package com.bucur.jvm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * HelloWorld class used to test jdk tools.
 */
public class RandomizerApp {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CYAN = "\u001B[36m";

    private static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        displayMenu();

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        dispatch(scanner, option);

        String firstArgument = args[0];
        String secondArgument = args[1];
        try {
            divide(Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayMenu() {
        System.out.println("Menu -----------------");
        System.out.println("1. add persons");
        System.out.println("2. select next person");
        System.out.println("3. load people from file");
        System.out.println("0. exit \n");
        System.out.println("Please choose an option:");
    }

    private static void addPersons() {
        int minDifficulty = 1;
        int maxDifficulty = 5;

        // for each input create a new person
        while (true) {
            System.out.println("Who is next? (press 'n' if everyone is ready)");

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            if (name.equals("n")) {
                break;
            }

            // create a person with a difficulty grade
            Person person = new Person(name, getRandomNumberInRange(minDifficulty, maxDifficulty));
            person.setPresent(true);

            // add person to the list
            personList.add(person);
        }
    }

    /**
     * Sums two integers.
     *
     * @param a first operand
     * @param b second operand
     * @return the sum of the operands
     * @throws IOException if a file is not found
     */
    public static int divide(int a, int b) throws IOException {
        Path path = Paths.get("C:\\dev\\sda\\sda\\jvm\\src\\main\\resources\\chrome-icon.ico");
        Files.readAllLines(path);

        return a / b;
    }

    private static void selectNextPerson() {
        if (personList.isEmpty()) {
            System.out.println("Everybody finished coding.");
            return;
        }

        System.out.println("Everybody is ready to code: " + personList);
        System.out.println("Let's see who is next.");

        // take persons from list and put them in a map
        Map<Integer, Person> personMap = new HashMap<>();
        for (int id = 1; id <= personList.size(); id++) {
            personMap.put(id, personList.get(id - 1));
        }

        sleep();
        System.out.println("Hmmmm... so hard to pick...");
        sleep();

        Random random = new Random();
        Person nextPerson;

        int nextPersonId;

        // if map contains only one person
        if (personMap.size() == 1) {
            // get first entry of the map (the only one left)
            Map.Entry<Integer, Person> entry = personMap.entrySet().iterator().next();
            nextPersonId = entry.getKey();

            // get first person in the list (the only one left)
            nextPerson = personList.get(0);
        } else {
            nextPersonId = random.nextInt(personList.size());
            nextPerson = personList.get(nextPersonId);
        }

        sleep();
        System.out.println(ANSI_CYAN + "I got it! Next person is: " + nextPerson.getName().toUpperCase() + ANSI_RESET);

        // interpret difficulty
        String difficultyInterpretation = interpretDifficulty(nextPerson.getDifficulty(), nextPerson.getName());
        System.out.println(difficultyInterpretation);

        // remove random person from list
        personList.remove(nextPerson);
        System.out.println("Person ids left in the list: " + personList);

        // remove person from map too
        if (personMap.size() == 1) {
            personMap.remove(nextPersonId);
        } else {
            personMap.remove(nextPersonId + 1);
        }
        System.out.println("Persons left in the map: " + personMap);
    }

    private static void dispatch(Scanner scanner, int option) {
        while (option != 0) {
            switch (option) {
                case 1:
                    addPersons();
                    break;
                case 2:
                    selectNextPerson();
                case 3:
                    loadPeopleFromFile();
                    break;
                default:
                    System.out.println("Choose one of the displayed options!");
            }
            displayMenu();
            option = scanner.nextInt();
        }
    }

    private static void loadPeopleFromFile() {
        System.out.println("Where is the file located? ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        Path sourcePath = Paths.get(answer);
        List<Person> people = new ArrayList<>();
        try {
            System.out.println("Reading people from file...");
            Files.readAllLines(sourcePath)
                .forEach(name -> people.add(createPerson(name)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person createPerson(String name) {
        return new Person(name, getRandomNumberInRange(1, 5));
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private static String interpretDifficulty(int difficulty, String name) {
        String uppercaseName = name.toUpperCase();
        if (difficulty == 1 || difficulty == 2) {
            return ANSI_GREEN + "Because " + uppercaseName + " is lazy, this will be a piece of cake!" + ANSI_RESET;
        } else if (difficulty == 3 || difficulty == 4) {
            return ANSI_YELLOW + "This won't be so easy but " + uppercaseName + " can handle it!" + ANSI_RESET;
        } else
            return ANSI_RED + "Ok, this will be hard... Poor " + uppercaseName + ANSI_RESET;
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
