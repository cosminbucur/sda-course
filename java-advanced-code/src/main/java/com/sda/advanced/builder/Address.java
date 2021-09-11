package com.sda.advanced.builder;

public class Address {

    private String county;

    private Address(AddressBuilder builder) {
        this.county = builder.county;
    }

    public String getCounty() {
        return county;
    }

    // a nested class can access the private members of the parent class
    public static class AddressBuilder {

        private String county;

        public AddressBuilder county(String county) {
            this.county = county;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
