package com.bucur.ex2;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void delete(Product product) {
        products.remove(product);
    }

    public int countProducts() {
        return products.size();
    }

    public int priceSum() {
        return products.stream()
            .map(product -> product.getPrice())
            .reduce(0, (a, b) -> a + b);
    }
}
