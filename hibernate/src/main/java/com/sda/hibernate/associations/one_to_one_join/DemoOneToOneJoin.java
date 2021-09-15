package com.sda.hibernate.associations.one_to_one_join;

public class DemoOneToOneJoin {

    public static void main(String[] args) {
        AccountDao accountDao = new AccountDao();

        Employee employee = new Employee();
        employee.setEmail("jonsnow@gmail.com");

        Account account = new Account();
        account.setAccountNumber("200");
        account.setEmployee(employee);

        employee.setAccount(account);

        // save both in one shot
        accountDao.create(account);
    }
}
