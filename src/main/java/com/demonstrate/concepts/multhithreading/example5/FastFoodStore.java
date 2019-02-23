package com.demonstrate.concepts.multhithreading.example5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.currentThread;

public class FastFoodStore {

    private static final Executor EXECUTOR = Executors.newCachedThreadPool();
    private static final CompletionService<FoodPlate> COMPLETION_SERVICE = new ExecutorCompletionService<>(EXECUTOR);

    private static final BlockingQueue<FoodPlate> ORDER = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<FutureTask> orderStatus = new ArrayList<>();
        Order order = new Order(COMPLETION_SERVICE, ORDER, orderStatus);
        new Thread(order).start();

        CollectOrder collectOrder = new CollectOrder(ORDER);
        new Thread(collectOrder).start();

        orderStatus.forEach(futureTask -> {
            try {
                FoodPlate foodPlate = (FoodPlate) futureTask.get();
                System.out.println(foodPlate.getOrderNumber() + " is ready");
            } catch (InterruptedException e) {
                currentThread().interrupt();
            } catch (ExecutionException e) {
            }
        });

    }
}
