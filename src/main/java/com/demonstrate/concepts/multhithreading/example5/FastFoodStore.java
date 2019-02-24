package com.demonstrate.concepts.multhithreading.example5;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * Fast food store
 * 1. First Runnable takes orders
 * 2. ExecutorCompletionService prepares the orders
 * 3. Second Runnable displays Ready orders
 * 4. Third Runnable tells which orders have been collected
 */
public class FastFoodStore {

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(4);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<FoodPlate> completionService = new ExecutorCompletionService<>(executorService);

        BlockingQueue<FoodPlate> foodPlatesReady = new ArrayBlockingQueue<>(10);

        BlockingQueue<FutureTask> orderStatus = new LinkedBlockingQueue<FutureTask>();
        Thread counterOneRunnable = counterOneOpen(completionService, foodPlatesReady, orderStatus);
        Thread counterTwoRunnable = counterTwoOpen(completionService, foodPlatesReady, orderStatus);

        Thread orderDisplayRunnable = displayCompletedOrdersOnScreen(orderStatus);

        Thread ordersDelivered = ordersReady(foodPlatesReady);

        sleep(20000);
        restaurantClosingTime(executorService);
        counterOneRunnable.join();
        counterTwoRunnable.join();

        allOrdersDelivered(foodPlatesReady, orderStatus, orderDisplayRunnable, ordersDelivered);
        COUNT_DOWN_LATCH.await();
        System.out.println("Restaurant closed");
    }

    private static void allOrdersDelivered(BlockingQueue<FoodPlate> foodPlatesReady, BlockingQueue<FutureTask> orderStatus, Thread orderDisplayRunnable, Thread ordersDelivered) {
        while (!(foodPlatesReady.isEmpty() && orderStatus.isEmpty())) {
        }
        System.out.println("All orders have been cooked, closing kitchen now.");
        ordersDelivered.interrupt();
        orderDisplayRunnable.interrupt();
    }

    private static Thread ordersReady(BlockingQueue<FoodPlate> foodPlatesReady) {
        CollectOrder collectOrder = new CollectOrder(foodPlatesReady, COUNT_DOWN_LATCH);
        Thread ordersDelivered = new Thread(collectOrder);
        ordersDelivered.start();
        return ordersDelivered;
    }

    private static Thread displayCompletedOrdersOnScreen(BlockingQueue<FutureTask> orderStatus) {
        OrderDisplayScreen orderDisplayScreen = new OrderDisplayScreen(orderStatus, COUNT_DOWN_LATCH);
        Thread orderDisplayRunnable = new Thread(orderDisplayScreen);
        orderDisplayRunnable.start();
        return orderDisplayRunnable;
    }

    private static Thread counterTwoOpen(CompletionService<FoodPlate> completionService, BlockingQueue<FoodPlate> foodPlatesReady, BlockingQueue<FutureTask> orderStatus) {
        Order counterTwo = new Order(completionService, foodPlatesReady, orderStatus, COUNT_DOWN_LATCH);
        Thread counterTwoRunnable = new Thread(counterTwo);
        counterTwoRunnable.start();
        return counterTwoRunnable;
    }

    private static Thread counterOneOpen(CompletionService<FoodPlate> completionService, BlockingQueue<FoodPlate> foodPlatesReady, BlockingQueue<FutureTask> orderStatus) {
        Order counterOne = new Order(completionService, foodPlatesReady, orderStatus, COUNT_DOWN_LATCH);
        Thread counterOneRunnable = new Thread(counterOne);
        counterOneRunnable.start();
        return counterOneRunnable;
    }

    private static void restaurantClosingTime(ExecutorService executorService) {
        System.out.println("Restautant closing in some time, no new orders would be taken. Counter closed");
        executorService.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            executorService.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }

    }
}
