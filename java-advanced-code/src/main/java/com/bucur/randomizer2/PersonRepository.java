package com.bucur.randomizer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PersonRepository {

    private static List<Person> people = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addPersons() {
        while (true) {
            System.out.println("Who's next? (press 'n' if all are ready");

            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("n")) {
                break;
            }

            int randomDifficulty = Utils.getRandomNumberInRange(1, 5);

            // create a person with the name and the random task difficulty
            Person person = new Person(name, randomDifficulty);
            person.setPresent(true);

            // don't forget to add it to the list
            people.add(person);
        }
    }

    public void selectNextPerson() {
        // return means get out of the method. if the list is empty
        // there is no point in going any further with the logic
        if (people.isEmpty()) {
            System.out.println("everyone finished coding");
            return;
        }

        // generate a random number based on the size of the list
        Random random = new Random();
        int nextPersonId = random.nextInt(people.size());

        // get the person by the random index
        Person nextPerson = people.get(nextPersonId);

        // print selected person info
        System.out.println("next person is: " + nextPerson.getName() +
            " with the task difficulty: " + nextPerson.getDifficulty());

        // remove that person from the list
        people.remove(nextPerson);
    }
}
