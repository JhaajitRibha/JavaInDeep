package Multithreading;

import java.time.LocalTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int NUMBER_OF_FRIENDS = 8;
        CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_FRIENDS,new Runnable(){

            @Override
            public void run() {
                System.out.println("chalo dosto chalte hai " + LocalTime.now());
            }
        });

        new Thread(new Runner(barrier,"ayaan",10l)).start();
        new Thread(new Runner(barrier,"hudge",20l)).start();
        new Thread(new Runner(barrier,"ashish",15l)).start();
        new Thread(new Runner(barrier,"alok",5l)).start();
        new Thread(new Runner(barrier,"chandu r",15l)).start();
        new Thread(new Runner(barrier,"bade",20l)).start();
        new Thread(new Runner(barrier,"sagar bhau",25l)).start();
        new Thread(new Runner(barrier,"gaurav",40l)).start();

    }
}

class Runner implements Runnable{

    private CyclicBarrier barrier;
    private String name;
    private Long timing;

    public Runner(CyclicBarrier barrier,String name,Long timing){
        this.barrier=barrier;
        this.timing=timing;
        this.name=name;
    }

    @Override
    public void run() {

        System.out.println(this.name  + " is getting ready for pune station at : " + LocalTime.now());
        try {
            Thread.sleep(timing*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.name + " reached pune station at : "+ LocalTime.now());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            this.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(this.name + ": chalo chalte hai :" + LocalTime.now());
    }
}
