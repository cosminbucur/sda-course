package com.sda.hibernate.associations.one_to_one;

public class DemoOneToOne {

    public static void main(String[] args) {
        CarDao carDao = new CarDao();

        Parking parking = new Parking();
        parking.setName("spot1");

        Car car = new Car();
        car.setLicensePlate("B20CAR");
        car.setParking(parking);

        parking.setCar(car);

        // save both in one shot
        carDao.create(car);
    }
}
