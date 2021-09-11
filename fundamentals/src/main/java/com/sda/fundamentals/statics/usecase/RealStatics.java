package com.sda.fundamentals.statics.usecase;

import static com.sda.fundamentals.statics.usecase.Constants.NOT_FOUND;

public class RealStatics {

    public static void main(String[] args) {
        useStaticFields();
        useStaticImport();
    }

    private static void useStaticFields() {
        Book book = new Book("123", "karamazov brothers");
        System.out.println(Constants.SAVED);

        // delete book
        System.out.println(Constants.DELETED);
    }

    private static void useStaticImport() {
        // find book
        // static import
        System.out.println(NOT_FOUND);
    }
}
