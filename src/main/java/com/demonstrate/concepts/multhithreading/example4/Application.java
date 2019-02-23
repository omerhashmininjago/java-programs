package com.demonstrate.concepts.multhithreading.example4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Producer and consumer problem using a concurrent buffer
 */
public class Application {

    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        initiateConsumption(queue);
        initiateProduction(queue);
    }

    private static void initiateConsumption(BlockingQueue queue) {
        Consumer consumer = new Consumer(queue);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }

    private static void initiateProduction(BlockingQueue queue) {
        List<Name> nameList = new ArrayList<>();
        populateDataForProducer(nameList);
        Producer producer = new Producer(queue, nameList);
        Thread producerThread = new Thread(producer);
        producerThread.start();
    }

    private static List<Name> populateDataForProducer(List<Name> nameList) {
        for (int i = 0; i < 10; i++) {
            nameList.add(new Name("firstName" + i, "lastName" + i));
        }
        return nameList;
    }
}
