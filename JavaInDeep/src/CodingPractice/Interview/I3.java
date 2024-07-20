package CodingPractice.Interview;



public class I3 {

    private static final int THREAD_COUNT = 3;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Printer(1, LOCK, THREAD_COUNT), "Thread-1");
        Thread t2 = new Thread(new Printer(2, LOCK, THREAD_COUNT), "Thread-2");
        Thread t3 = new Thread(new Printer(3, LOCK, THREAD_COUNT), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Printer implements Runnable {
    private final int tracker;
    private final Object lock;
    private final int threadCount;

    private static int counter = 0;

    Printer(int tracker, Object lock, int threadCount) {
        this.tracker = tracker;
        this.lock = lock;
        this.threadCount = threadCount;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (counter >= 50) {
                    lock.notifyAll();
                    break;
                }
                if ((counter % threadCount) + 1 == tracker) {
                    print();
                    counter++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }

    private void print() {
        System.out.println(counter + 1 + " printed by: " + Thread.currentThread().getName() + " (tracker: " + tracker + ")");
    }
}
