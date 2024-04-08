package DesignPattern.DeepCopyImplementation;


import java.util.ArrayList;
import java.util.List;

public class DeepCopyController {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {


        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.loadImportantData();



        NetworkConnection networkConnection1 = (NetworkConnection) networkConnection.clone();
        NetworkConnection networkConnection2 = (NetworkConnection) networkConnection.clone();


        System.out.println(networkConnection);
        System.out.println(networkConnection1);
        System.out.println(networkConnection2);

        networkConnection2.getDomains().remove(0);
        networkConnection1.getDomains().add("hulala.com");

        System.out.println(networkConnection);
        System.out.println(networkConnection1);
        System.out.println(networkConnection2);









    }
}
