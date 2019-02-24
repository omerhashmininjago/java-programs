package com.demonstrate.concepts.multhithreading.example5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.currentThread;

public class OrderDisplayScreen implements Runnable {

    private final BlockingQueue<FutureTask> orderStatus;
    private final CountDownLatch countDownLatch;

    public OrderDisplayScreen(BlockingQueue<FutureTask> orderStatus, CountDownLatch countDownLatch) {
        this.orderStatus = orderStatus;
        this.countDownLatch = countDownLatch;
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
        countDownLatch.countDown();
    }
}
