package DesignPattern.DeepCopyImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetworkConnection implements Cloneable{

    private String ip;
    private String importantData;

    private List<String> domains = new ArrayList<>();

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImportantData() {
        return importantData;
    }

    public void setImportantData(String importantData) {
        this.importantData = importantData;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public void loadImportantData() throws InterruptedException {
        this.domains.add("www.learnwithajit");
        this.domains.add("www.dev.com");
        this.domains.add("www.qc.com");
        this.domains.add("www.sustenance.com");
        Thread.sleep(2000);
        this.importantData = "load very very important data";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIp(this.ip);
        networkConnection.setImportantData(this.importantData);
        domains.stream().forEach(e->networkConnection.domains.add(e));
        return networkConnection;
    }

    @Override
    public String toString() {
        return this.ip + " , " + this.domains + " " + this.importantData;
    }


}
