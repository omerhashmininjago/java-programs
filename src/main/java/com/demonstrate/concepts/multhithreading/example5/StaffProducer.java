package com.demonstrate.concepts.multhithreading.example5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class StaffProducer implements Callable<FoodPlate> {

    private final BlockingQueue<FoodPlate> foodPlates;
    private final StaffName staffName;

    public StaffProducer(StaffName staffName, BlockingQueue foodPlates) {
        this.staffName = staffName;
        this.foodPlates = foodPlates;
    }

    @Override
    public FoodPlate call() throws Exception {

        FoodPlate foodPlate = new FoodPlate(true, true, staffName, Math.random() * 1000);
        System.out.println(staffName + " is preparing plate");
        sleep(2000);
        foodPlates.put(foodPlate);
        return foodPlate;
    }
}
