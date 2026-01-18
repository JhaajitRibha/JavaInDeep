package Multithreading.Executors.newFixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NFTPA2 {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        Runnable task1 = new ThreadOne();
        Runnable task2 = new ThreadTwo();
        Runnable task3 = new ThreadThree();
        Runnable task4 = new ThreadFour();
        ;

        service.submit(task1);
        service.submit(task2);
        service.submit(task3);
        service.submit(task4);

        service.shutdown();


    }
}

    class ThreadOne implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <=20; i++) {
                System.out.println("printing " + i + " by : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("printed " + i + " by : " + Thread.currentThread().getName());
            }

        }
    }

    class ThreadTwo implements Runnable {

        @Override
        public void run() {
            for (int i = 21; i <=40; i++) {
                System.out.println("printing " + i + " by : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("printed " + i + " by : " + Thread.currentThread().getName());

            }
        }
    }

    class ThreadThree implements Runnable {

        @Override
        public void run() {
            for (int i = 41; i <=70; i++) {
                System.out.println("printing " + i + " by : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("printed " + i + " by : " + Thread.currentThread().getName());

            }
        }
    }

    class ThreadFour implements Runnable {

        @Override
        public void run() {
            for (int i = 71; i <= 100; i++) {
                System.out.println("printing " + i + "by : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("printed " + i + "by : " + Thread.currentThread().getName());

            }
        }
    }

