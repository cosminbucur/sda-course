package com.bucur.ex2;

public class DemoEx2 {

    public static void main(String[] args) {
        Product cube = new Product();
        cube.setName("cube");
        cube.setPrice(20);

        Product cylinder = new Product();
        cylinder.setName("cylinder");
        cylinder.setPrice(30);

        Warehouse warehouse = new Warehouse();
        warehouse.addProduct(cube);
        warehouse.addProduct(cylinder);

        System.out.println("products in warehouse: " + warehouse.countProducts());

        System.out.println("total price of products: " + warehouse.priceSum());
    }
}
