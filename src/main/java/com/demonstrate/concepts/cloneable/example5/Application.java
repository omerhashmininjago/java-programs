package com.demonstrate.concepts.cloneable.example5;

import org.apache.commons.lang3.SerializationUtils;

/**
 * Deep cloning using external library i.e. apache commons
 *
 */
public class Application {

    public static void main(String[] args) {

        Car car = new Car("XeX");
        CarInfo carInfo = new CarInfo(1, car);

        CarInfo clone = SerializationUtils.clone(carInfo);
        clone.setId(2);
        clone.setCar(new Car("YeY"));

        System.out.println("car1Info id : " + carInfo.getId());
        System.out.println("car1Info carName : " + carInfo.getCar().getCarName());
        System.out.println("car2Info id : " + clone.getId());
        System.out.println("car2Info carName : " + clone.getCar().getCarName());

        if (carInfo.getCar() == clone.getCar()) {
            System.out.println("Car is the same reference");
        } else System.out.println("Car has different reference");

        if (carInfo.getCar().equals(clone.getCar())) {
            System.out.println("Car is same object");
        } else System.out.println("Car is different object");

        if (carInfo == clone) {
            System.out.println("Employee has same reference");
        } else System.out.println("Employee has different reference");

    }
}

