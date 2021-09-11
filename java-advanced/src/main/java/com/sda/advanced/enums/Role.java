package com.sda.advanced.enums;

public enum Role {

    FIGHTER("sword ready"),
    ARCHER("arrows ready"),
    ASSASSIN("poison ready");

    private String description;

    // private is redundant (private by default for enums)
    private Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void printEnum() {
        for (Role role : Role.values()) {
            System.out.println(role.name() + " " + role.ordinal() + " " + role.getDescription());
        }
    }

    @Override
    public String toString() {
        return "Role{" +
            "description='" + description + '\'' +
            '}';
    }
}
