package Multithreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ESE1 {
    public static void main(String[] args) {

        ExecutorService executors = Executors.newFixedThreadPool(1);
        for(int i=1;i<=10;i++){
            executors.submit(new Task("samar : " + i));

        }

        executors.shutdown();
    }

}

class Task implements Runnable{

    private String name;

    Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("printing by " + i + " :  "  + name);
        }
    }
}
