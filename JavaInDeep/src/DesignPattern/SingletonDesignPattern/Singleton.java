package DesignPattern.SingletonDesignPattern;

public class Singleton {

    private static Singleton instance;
    private Singleton(){
        System.out.println("singleton instance created ..");
    }

    public static synchronized Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("hello from singleton class");
    }

}
