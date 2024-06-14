package Multithreading;


import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedElement implements Delayed {
    private String data;
    private long delayTime;
    private long expiryTime;

    public DelayedElement(String data, long delayTime) {
        this.data = data;
        this.delayTime = delayTime;
        this.expiryTime = System.currentTimeMillis() + delayTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = expiryTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long diff = this.expiryTime - ((DelayedElement) o).expiryTime;
        return Long.compare(diff, 0);
    }

    public String getData() {
        return data;
    }


}

public class DelayQueueExample {
    public static void main(String[] args) {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();

        // Add elements to the delay queue with different delays
        delayQueue.offer(new DelayedElement("Task 1", 3000)); // Task 1 will be delayed for 3000 milliseconds
        delayQueue.offer(new DelayedElement("Task 2", 2000)); // Task 2 will be delayed for 2000 milliseconds
        delayQueue.offer(new DelayedElement("Task 3", 5000)); // Task 3 will be delayed for 5000 milliseconds

        // Start a consumer thread to process elements when their delays expire
        Thread consumerThread = new Thread(() -> {
            try {
                while (!delayQueue.isEmpty()) {
                    DelayedElement element = delayQueue.take(); // This will block until an element's delay expires
                    System.out.println("Processing: " + element.getData() + " at " + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumerThread.start();
    }
}



