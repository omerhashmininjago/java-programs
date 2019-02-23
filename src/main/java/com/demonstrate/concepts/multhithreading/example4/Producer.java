package com.demonstrate.concepts.multhithreading.example4;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.interrupted;

public class Producer implements Runnable {

    private BlockingQueue<Name> buffer;
    private List<Name> nameList;

    public Producer(BlockingQueue<Name> buffer, List<Name> nameList) {
        this.buffer = buffer;
        this.nameList = nameList;
    }

    @Override
    public void run() {

        nameList.forEach(name -> {
            buffer.offer(name);
            System.out.println(name + " is ready for consumption");
        });
    }
}
