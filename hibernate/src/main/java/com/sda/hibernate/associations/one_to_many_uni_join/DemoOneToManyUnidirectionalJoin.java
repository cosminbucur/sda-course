package com.sda.hibernate.associations.one_to_many_uni_join;

public class DemoOneToManyUnidirectionalJoin {

    public static void main(String[] args) {
        FatherDao fatherDao = new FatherDao();

        Son son1 = new Son();
        son1.setName("son1");

        Son son2 = new Son();
        son2.setName("son2");

        Father father = new Father();
        father.setName("father");

        // add children to parent
        father.getSons().add(son1);
        father.getSons().add(son2);

        // save parent
        fatherDao.create(father);
    }
}
