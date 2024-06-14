package Multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {

            BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

            Thread producerThread = new Thread(new Producer(queue));
            Thread consumerThread = new Thread(new Consumer(queue));

            producerThread.start();
            consumerThread.start();
        }


}

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                // Producing items and adding them to the queue
                queue.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep(1000); // Simulating production time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Consuming items from the queue
                int item = queue.take();
                System.out.println("Consumed: " + item);
                Thread.sleep(25000); // Simulating consumption time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}