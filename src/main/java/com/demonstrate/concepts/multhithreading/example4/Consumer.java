package com.demonstrate.concepts.multhithreading.example4;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.interrupted;

public class Consumer implements Runnable {

    private final BlockingQueue<Name> buffer;
    private final Name name;

    public Consumer(BlockingQueue<Name> buffer) {
        this.buffer = buffer;
        this.name = new Name("firstName20", "lastName20");
    }

    @Override
    public void run() {

        Set<Name> consumedData = new HashSet<>();

        while (!currentThread().isInterrupted()) {
            Name name = null;
            try {
                name = buffer.take();
            } catch (InterruptedException e) {
                interrupted();
            }
            if (Objects.nonNull(name)) {
                if (this.name.equals(name)) {
                    System.out.println("Minimum Data consumed, going to interrupt Consumer Thread");
                    currentThread().interrupt();
                }
                consumedData.add(name);
            }
        }
        System.out.println("Consumer has performed its task; Below data was consumed");
        System.out.println(consumedData);
    }
}
