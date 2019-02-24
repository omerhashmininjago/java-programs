package com.demonstrate.concepts.multhithreading.example5;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * Fast food store
 * 1. First Runnable takes orders
 * 2. ExecutorCompletionService prepares the orders
 * 3. Second Runnable displays Ready orders
 * 4. Third Runnable tells which orders have been collected
 * 5. Using a CountDownLatch to make sure all orders are delivered before closing the restaurant.
 */
public class FastFoodStore {

    private static final CountDownLatch RESTAURANT_CLOSED_FLAG = new CountDownLatch(4);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<FoodPlate> completionService = new ExecutorCompletionService<>(executorService);

        BlockingQueue<FoodPlate> foodPlatesReady = new ArrayBlockingQueue<>(10);

        BlockingQueue<FutureTask> orderStatus = new LinkedBlockingQueue<FutureTask>();
        counterOneOpen(completionService, foodPlatesReady, orderStatus);
        counterTwoOpen(completionService, foodPlatesReady, orderStatus);

        Thread orderDisplayRunnable = displayCompletedOrdersOnScreen(orderStatus);

        Thread ordersDelivered = ordersReady(foodPlatesReady);

        sleep(20000);
        restaurantClosingTime(executorService);

        allOrdersDelivered(foodPlatesReady, orderStatus, orderDisplayRunnable, ordersDelivered);
        RESTAURANT_CLOSED_FLAG.await();
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
        CollectOrder collectOrder = new CollectOrder(foodPlatesReady, RESTAURANT_CLOSED_FLAG);
        Thread ordersDelivered = new Thread(collectOrder);
        ordersDelivered.start();
        return ordersDelivered;
    }

    private static Thread displayCompletedOrdersOnScreen(BlockingQueue<FutureTask> orderStatus) {
        OrderDisplayScreen orderDisplayScreen = new OrderDisplayScreen(orderStatus, RESTAURANT_CLOSED_FLAG);
        Thread orderDisplayRunnable = new Thread(orderDisplayScreen);
        orderDisplayRunnable.start();
        return orderDisplayRunnable;
    }

    private static void counterTwoOpen(CompletionService<FoodPlate> completionService, BlockingQueue<FoodPlate> foodPlatesReady, BlockingQueue<FutureTask> orderStatus) {
        Order counterTwo = new Order(completionService, foodPlatesReady, orderStatus, RESTAURANT_CLOSED_FLAG);
        Thread counterTwoRunnable = new Thread(counterTwo);
        counterTwoRunnable.start();
    }

    private static void counterOneOpen(CompletionService<FoodPlate> completionService, BlockingQueue<FoodPlate> foodPlatesReady, BlockingQueue<FutureTask> orderStatus) {
        Order counterOne = new Order(completionService, foodPlatesReady, orderStatus, RESTAURANT_CLOSED_FLAG);
        Thread counterOneRunnable = new Thread(counterOne);
        counterOneRunnable.start();
    }

    private static void restaurantClosingTime(ExecutorService executorService) {
        System.out.println("Restaurant closing in some time, no new orders would be taken. Counter closed");
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
