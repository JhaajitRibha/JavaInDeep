package Multithreading;


class MyThread extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(2000);
                System.out.println("executed by index " + i + "by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class MyThread2 extends Thread{
    public void run(){
        for(int i=100;i<110;i++){
            try {
                Thread.sleep(4000);
                System.out.println("executed by index " + i + "by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyThread3 extends Thread{
    public void run(){
        for(int i=200;i<210;i++){
            try {
                Thread.sleep(8000);
                System.out.println("executed by index " + i + "by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadUsingThread {

    public static void main(String[] args) {

        MyThread t = new MyThread();
        MyThread2 t2 = new MyThread2();
        MyThread3 t3 = new MyThread3();

        t.start();
        t2.start();
        t3.start();
    }
}
