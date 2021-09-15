package com.sda.jdbc.prepared_statement;

public class DemoPreparedStatements {

    public static void main(String[] args) {
        PreparedStatements preparedStatements = new PreparedStatements();
        preparedStatements.insertOperation("jon", "jonsnow@gmail.com", "westeros");
        preparedStatements.updateOperation(1, "alex", "alexvasile@gmail.com", "romania");
        preparedStatements.deleteOperation(1);
    }
}
