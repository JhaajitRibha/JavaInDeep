package Multithreading;

public class Basic {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread 1" + ": " + i + "by " + Thread.currentThread().getName());
                }
        });

        Thread t2 = new Thread(()->{
            for(int i=11;i<20;i++){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread 2 : " + i + " by " + Thread.currentThread().getName());
            }
        });

        t.start();
        t2.start();
    }
}
