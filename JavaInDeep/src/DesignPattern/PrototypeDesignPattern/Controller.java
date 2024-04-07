package DesignPattern.PrototypeDesignPattern;

public class Controller {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("creating object");
        NetworkConnection networkConnection  = new NetworkConnection();
        networkConnection.setIp("192.168.4.242");
        networkConnection.loadImportantData();
        System.out.println(networkConnection);

       
        try {
            NetworkConnection networkConnection1 = (NetworkConnection) networkConnection.clone();
            System.out.println(networkConnection1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
