package Multithreading.Executors.NewSingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NSTEA1 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i=1;i<25;i++){
            Runnable friend = new Friends("friend,"+i);
            executorService.execute(friend);
        }

        executorService.shutdown();

    }
}

class Friends implements Runnable{
    private String name;

    public Friends(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : coming in 5 sec : " + name);
        try {
            sleeping(5000);
        } catch (InterruptedException e) {
            System.out.println("interrupted .. ");
        }
        System.out.println(Thread.currentThread().getName() + " : came : " + name);

    }

    private void sleeping(long time) throws InterruptedException {
        Thread.sleep(time);
    }
}