package Multithreading.Executors.newFixedThreadPool;

import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NFTPA1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);

        for(int i=1;i<=25;i++){
            Runnable task = new WorkerThread("task : "+ i);
            executorService.execute(task);
        }

        executorService.shutdown();

        if(!executorService.awaitTermination(22, TimeUnit.SECONDS)){
            executorService.shutdownNow();

        }

        System.out.println("finished all threads...");
    }
}


class WorkerThread implements Runnable{

    private String command;

    public WorkerThread(String command){
        this.command=command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start. command : " + this.command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+ " end. command : " + this.command);
    }

    private void processCommand(){
        try{
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            System.out.println("sleep interrupted ...");
        }
    }

    public String toString(){
        return this.command;
    }
}