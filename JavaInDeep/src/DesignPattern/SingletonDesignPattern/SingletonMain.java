package DesignPattern.SingletonDesignPattern;

public class SingletonMain {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        s.showMessage();

        Singleton s2 = Singleton.getInstance();
        s2.showMessage();
    }
}
