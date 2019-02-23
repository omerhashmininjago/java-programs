package com.demonstrate.concepts.multhithreading.example4;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.currentThread;

public class Producer implements Runnable {

    private final BlockingQueue<Name> buffer;
    private List<Name> nameList;

    public Producer(BlockingQueue<Name> buffer, List<Name> nameList) {
        this.buffer = buffer;
        this.nameList = nameList;
    }

    @Override
    public void run() {

        nameList.forEach(name -> {
            try {
                buffer.put(name);
            } catch (InterruptedException e) {
                currentThread().interrupt();
            }
            System.out.println(name + " is ready for consumption");
        });
    }
}
