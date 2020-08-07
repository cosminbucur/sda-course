package com.bucur.associations.one_to_many_bi;

public class DemoOneToManyBidirectional {

    public static void main(String[] args) {
        ParentDao parentDao = new ParentDao();

        Child child1 = new Child();
        child1.setTitle("child1");

        Child child2 = new Child();
        child2.setTitle("child2");

        Parent parent = new Parent();
        parent.setName("parent");
        parent.setEmail("parent@gmail.com");
        parent.setCountry("home");

        parent.addChild(child1);
        parent.addChild(child2);

        parentDao.create(parent);
    }
}
