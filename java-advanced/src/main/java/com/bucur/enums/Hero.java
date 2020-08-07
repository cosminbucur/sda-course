package com.bucur.enums;

public class Hero {

    private int hp;
    private Role role;

    public Hero(int hp, Role role) {
        this.hp = hp;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
