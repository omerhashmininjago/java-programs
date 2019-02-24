package com.demonstrate.concepts.multhithreading.example6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * Demonstrating how a ScheduledExecutorService works
 */
public class BeeperControl {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        beepForAnHour(scheduler);
    }

    public static void beepForAnHour(ScheduledExecutorService scheduler) {
        final Runnable beeper = () -> System.out.println("beep");

        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);

        final Runnable stopSchedular = () ->
                beeperHandle.cancel(true);

        scheduler.schedule(stopSchedular, 60, SECONDS);

    }
}
