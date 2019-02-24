package com.demonstrate.concepts.multhithreading.example5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Order implements Runnable {

    private final CompletionService<FoodPlate> foodPlateCompletionService;
    private final BlockingQueue<FoodPlate> ordersPrepared;
    private BlockingQueue<FutureTask> orderStatus;

    public Order(CompletionService<FoodPlate> foodPlateCompletionService, BlockingQueue<FoodPlate> ordersPrepared, BlockingQueue<FutureTask> orderStatus) {
        this.foodPlateCompletionService = foodPlateCompletionService;
        this.ordersPrepared = ordersPrepared;
        this.orderStatus = orderStatus;
    }

    @Override
    public void run() {
        for (int i = 1; i < 15; i++) {
            String staffName = String.valueOf(Thread.currentThread().getId());
            long orderNo = (long) (Math.random() * 1000);
            System.out.println(staffName + " is taking order " + orderNo);
            try {
                //Taking orders takes time; hence putting a sleep here
                sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
                currentThread().interrupt();
            }
            OrderInProgress orderInProgress = new OrderInProgress(new StaffName("Staff", staffName), ordersPrepared, orderNo);
            orderStatus.add((FutureTask) foodPlateCompletionService.submit(orderInProgress));
        }
    }
}
