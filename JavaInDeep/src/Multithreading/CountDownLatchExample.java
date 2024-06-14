package Multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);
        Thread t = new Thread(new Friends(latch,"ajit"));
        Thread t2 = new Thread(new Friends(latch,"samar"));
        Thread t3 =  new Thread(new Friends(latch,"rahul"));

        t.start();
        t2.start();
        t3.start();

        System.out.println(" starting the process " + LocalDateTime.now());
        latch.await();
        System.out.println(" everyone reached their location.."  + LocalDateTime.now());
        System.out.println(" now will start moving to reach my location");
        Thread.sleep(30000);
        System.out.println("reached my location at " + LocalDateTime.now());



    }
}


class Friends implements Runnable{

    private final CountDownLatch latch;
    private final String name;

    public Friends(CountDownLatch latch,String name){
        this.latch=latch;
        this.name = name;
    }



    @Override
    public void run() {

        System.out.println(this.name + " left the home at " + LocalDateTime.now());
        try {
            Thread.sleep(35000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.name + " reached his location at " + LocalDateTime.now());
        this.latch.countDown();
    }
}