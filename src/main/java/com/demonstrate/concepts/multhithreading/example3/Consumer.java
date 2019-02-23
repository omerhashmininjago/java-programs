package com.demonstrate.concepts.multhithreading.example3;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.interrupted;
import static java.util.Objects.isNull;

public class Consumer implements Runnable {

    private final Queue<Name> buffer;
    private final Object lock;
    private final Name name;

    public Consumer(Queue<Name> buffer, Object lock) {
        this.buffer = buffer;
        this.lock = lock;
        this.name = new Name("firstName8", "lastName8");
    }

    @Override
    public void run() {

        Set<Name> consumedData = new HashSet<>();

        while (!currentThread().isInterrupted()) {
            synchronized (lock) {
                while (isNull(buffer.peek())) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Consumer Thread Interrupted");
                        interrupted();
                    }
                }
                Name name = buffer.poll();
                if (this.name.equals(name)) {
                    System.out.println("Minimum Data consumed, going to interrupt Consumer Thread");
                    currentThread().interrupt();
                }
                consumedData.add(name);
                lock.notifyAll();
            }
        }
        System.out.println("Consumer has performed its task; Below data was consumed");
        System.out.println(consumedData);
    }
}
