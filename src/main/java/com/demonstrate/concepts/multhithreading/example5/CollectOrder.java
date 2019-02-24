package com.demonstrate.concepts.multhithreading.example5;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.currentThread;

public class CollectOrder implements Runnable {

    private final BlockingQueue<FoodPlate> foodPlatesBuffer;

    public CollectOrder(BlockingQueue<FoodPlate> foodPlatesBuffer) {
        this.foodPlatesBuffer = foodPlatesBuffer;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            FoodPlate foodPlate = null;
            try {
                foodPlate = foodPlatesBuffer.take();
            } catch (InterruptedException e) {
                currentThread().interrupt();
            }
            if (Objects.nonNull(foodPlate)) {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    currentThread().interrupt();
                }
                System.out.println(foodPlate.getOrderNumber() + " is delivered");
            }
        }

        System.out.println("All orders delivered");
    }
}
