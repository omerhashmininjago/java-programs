package com.demonstrate.concepts.multhithreading.example3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Application {

    public static void main(String[] args) {
        Queue queue = new LinkedList();
        Object lock = new Object();
        initiateProduction(queue, lock);
        initiateConsumption(queue, lock);
    }

    private static void initiateConsumption(Queue queue, Object lock) {
        Consumer consumer = new Consumer(queue, lock);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }

    private static void initiateProduction(Queue queue, Object lock) {
        List<Name> nameList = new ArrayList<>();
        populateDataForProducer(nameList);
        Producer producer = new Producer(queue, lock, nameList);
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
