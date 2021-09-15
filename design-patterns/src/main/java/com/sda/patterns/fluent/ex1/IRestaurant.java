package com.sda.patterns.fluent.ex1;

public interface IRestaurant {
    IRestaurant name(String name);

    IMenu show();
}
