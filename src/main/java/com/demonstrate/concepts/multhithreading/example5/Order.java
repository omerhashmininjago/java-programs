package com.demonstrate.concepts.multhithreading.example5;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.FutureTask;

public class Order implements Runnable {

    private final CompletionService<FoodPlate> foodPlateCompletionService;
    private final BlockingQueue<FoodPlate> ordersPrepared;
    private List<FutureTask> orderStatus;
    public Order(CompletionService<FoodPlate> foodPlateCompletionService, BlockingQueue<FoodPlate> ordersPrepared, List<FutureTask> orderStatus) {
        this.foodPlateCompletionService = foodPlateCompletionService;
        this.ordersPrepared = ordersPrepared;
        this.orderStatus = orderStatus;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            StaffProducer staffProducer = new StaffProducer(new StaffName("Staff", "" + i), ordersPrepared);
            orderStatus.add((FutureTask) foodPlateCompletionService.submit(staffProducer));
        }
    }
}
