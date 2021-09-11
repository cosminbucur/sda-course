package com.bucur.patterns.structural.decorator;

// TODO: 6. add client code
public class DemoDecoratorPattern {

    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        DataSourceDecorator encoded = new CompressionDecorator(
            new EncryptionDecorator(
                new FileDataSource("C:\\dev\\sda\\sda\\design-patterns\\src\\main\\resources\\decoratorOutput.txt")));
        encoded.writeData(salaryRecords);

        DataSource plain = new FileDataSource("C:\\dev\\sda\\sda\\design-patterns\\src\\main\\resources\\decoratorOutput.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
