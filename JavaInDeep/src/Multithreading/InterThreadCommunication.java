package Multithreading;

public class InterThreadCommunication {

    private static final int threadCount = 3;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Printer(1,lock,threadCount));
        Thread t2 = new Thread(new Printer(2,lock,threadCount));
        Thread t3 = new Thread(new Printer(3,lock,threadCount));

        t3.start();
        t2.start();
        t1.start();


    }
    
    

}

class Printer implements Runnable{
    private final int tracker;
    private final Object lock;
    private final int threadCount;

    private static int counter = 0;

    Printer(int tracker, Object lock, int threadCount) {
        this.tracker = tracker;
        this.lock = lock;
        this.threadCount=threadCount;
    }

    @Override
    public void run() {

        while(true){
            synchronized (lock) {
                if (counter >=50) {
                    lock.notifyAll();
                    break;
                }
                if ((counter % threadCount)+1 == tracker) {
                    System.out.println(counter+1 + " printed by : " + Thread.currentThread().getName() + "by : " + tracker);
                    counter++;
                    lock.notifyAll();

                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}

