package com.demonstrate.concepts.multhithreading.example2;

public class InterrputThread {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getId() + " has started to execute");
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getId() + " has started to execute");
            while (!Thread.currentThread().isInterrupted()) {

                System.out.println(Thread.currentThread().getId() + " is working");
            }
            System.out.println(Thread.currentThread().getId() + " has been interrupted - Now its the thread's call to take the next decision, either to stop processing or not");
            System.out.println(Thread.currentThread().getId() + " Ideally the thread should start clearing all the resources being used");
        };

        Thread threadOne = new Thread(task);

        threadOne.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // •If the thread is blocked, or waiting then the corresponding method will throw an InterruptedException
        }
        threadOne.interrupt();
        System.out.println(Thread.currentThread().getId() + " Thread One has been interrupted");
        try{
            // Calling join on threadOne from the main thread main ensures that the main thread will wait till threadOne finishes its work
            threadOne.join();
        } catch (InterruptedException e) {
            // If the thread is blocked, or waiting then the corresponding method will throw an InterruptedException
        }
        System.out.println(Thread.currentThread().getId() + " Now main thread can continue on further activity");

    }
}
