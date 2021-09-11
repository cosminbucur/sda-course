package com.bucur.statement;

public class DemoStatements {

    public static void main(String[] args) {
        Statements statements = new Statements();
        statements.insertOperation("jon", "jonsnow@gmail.com", "westeros");
        statements.queryOperation();
        statements.updateOperation(1, "alex", "alexvasile@gmail.com", "romania");
        statements.queryOperation();
        statements.deleteOperation(1);
    }
}
