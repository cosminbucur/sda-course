package com.sda.fundamentals.variables;

public class RealVariables {

    public static void main(String[] args) {
        int age = 30;

        // https://www.epochconverter.com/
        long timestamp = 1612546047L;

        double price = 20.5;

        boolean isActive = true;

        char firstLetter = 'a';

        char tab = '\t';

        // LF line feed moves the cursor down to the next line without returning to the beginning of the line
        char newLine = '\n';

        // CR moves the cursor to the beginning of the line without advancing to the next line
        char carriageReturn = '\r';

        String someText = "java code";

        // https://www.rapidtables.com/code/text/unicode-characters.html
        System.out.println(firstLetter + 1);    // 97 + 1

        System.out.println(price + "---" + newLine);

        System.out.println(age + ":" + tab + ":" + timestamp);

        System.out.println(isActive + ":" + someText);
    }

}
