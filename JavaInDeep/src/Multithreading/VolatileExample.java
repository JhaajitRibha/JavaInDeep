package Multithreading;

public class VolatileExample {
    private volatile boolean flag=false;

    public void togleFlag(){
        flag = !flag;
    }


    public boolean getFlag(){
        return flag;
    }

    public static void main(String[] args) {

        VolatileExample s =new VolatileExample();

        Thread toggleThread = new Thread(()->{
            while(true){
                try {
                    Thread.sleep(2000);

                    System.out.println("togglee value : "+ s.getFlag() + " by " + Thread.currentThread().getName());
                    System.out.println();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread readThread = new Thread(()->{
            while(true){
                try{
                    Thread.sleep(2000);
                    s.togleFlag();
                    System.out.println(s.getFlag() +  " by " + Thread.currentThread().getName());
                    System.out.println();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        toggleThread.start();
        readThread.start();


    }
}
