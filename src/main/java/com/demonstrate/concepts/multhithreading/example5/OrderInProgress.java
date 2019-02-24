package com.demonstrate.concepts.multhithreading.example5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class OrderInProgress implements Callable<FoodPlate> {

    private final BlockingQueue<FoodPlate> foodPlates;
    private final StaffName staffName;
    private final long orderNo;

    public OrderInProgress(StaffName staffName, BlockingQueue foodPlates, long orderNo) {
        this.staffName = staffName;
        this.foodPlates = foodPlates;
        this.orderNo = orderNo;
    }

    @Override
    public FoodPlate call() throws Exception {

        FoodPlate foodPlate = new FoodPlate(true, true, staffName, orderNo);
        System.out.println(foodPlate.getOrderNumber() + " is in preparation");
        // Order Preparation takes time; hence putting sleep here
        sleep((long) (Math.random() * 2000));
        foodPlates.put(foodPlate);
        return foodPlate;
    }
}
