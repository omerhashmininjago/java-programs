package com.demonstrate.concepts.multhithreading.example5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.currentThread;

public class OrderDisplayScreen implements Runnable {

    private BlockingQueue<FutureTask> orderStatus;

    public OrderDisplayScreen(BlockingQueue<FutureTask> orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            try {
                FutureTask futureTask = orderStatus.take();
                FoodPlate foodPlate = (FoodPlate) futureTask.get();
                System.out.println(foodPlate.getOrderNumber() + " is ready");
            } catch (InterruptedException e) {
                currentThread().interrupt();
            } catch (ExecutionException e) {
            }
        }
        System.out.println("All orders completed");
    }
}
