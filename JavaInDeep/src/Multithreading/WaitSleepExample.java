package Multithreading;


class OddsPrinter implements Runnable{

    private int limit;
    private Object lock;

    private int starter;

    public OddsPrinter(int limit,Object lock){
        this.limit=limit;
        this.lock = lock;
        this.starter=1;
    }
    @Override
    public void run() {
        synchronized (lock) {
            while (starter < limit) {
                System.out.println(starter + " by " + Thread.currentThread().getName());
                starter += 2;
                lock.notify();
                if (starter > limit) {
                    break;
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}

class EventPrinter implements Runnable{
    private int limit;
    private Object lock;

    private int starter;

    public EventPrinter(int limit,Object lock){
        this.limit=limit;
        this.lock = lock;
        this.starter=2;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (starter <= limit) {
                System.out.println(starter + " by " + Thread.currentThread().getName());
                starter += 2;
                lock.notify();
                if (starter > limit) {

                    break;
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
public class WaitSleepExample {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread producer = new Thread(new OddsPrinter(20,lock));
        Thread consumer = new Thread(new EventPrinter(20,lock));

        producer.start();
        Thread.sleep(5000);
        consumer.start();


    }
}
