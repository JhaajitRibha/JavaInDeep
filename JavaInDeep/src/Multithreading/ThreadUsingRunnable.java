package Multithreading;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
                System.out.println("executed by index " + i + " by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 100; i < 110; i++) {
            try {
                Thread.sleep(4000);
                System.out.println("executed by index " + i + " by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadUsingRunnable {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable2());

        t.start(); 
        t2.start();
    }
}
