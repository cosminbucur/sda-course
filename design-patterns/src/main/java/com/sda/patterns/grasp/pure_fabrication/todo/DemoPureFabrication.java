package com.sda.patterns.grasp.pure_fabrication.todo;

public class DemoPureFabrication {

    // the service does not map to a real life object but it is used
    // to get data from a source for example
    public static void main(String[] args) {
        Sale sale = new Sale();

        PersistentStorage persistentStorage = new PersistentStorage();
        persistentStorage.insert(sale);

    }
}
