package DesignPattern.ObserverDesignPattern.FirstProgram;

public class Subscriber implements Observer{

    private String name;

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void notified(String title,String videoName) {

        System.out.println("*******************************");
        System.out.println("new video Upload : notification | " +name + " jee");
        System.out.println("by :" + videoName);
        System.out.println("title :"+title );
        System.out.println("********************************");

    }
}
