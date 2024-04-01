package DesignPattern.adapterDesignPattern.FirstProgram;

public class Controller {
    public static void main(String[] args) {

        AppleCharger charger = new AppleChargerImplementation();
        AndroidCharger chargerTwo = new AndroidChargerImplementation();
        AdapterCharger adapter = new AdapterCharger(chargerTwo);
        Iphone14proMax iphone = new Iphone14proMax(adapter);

        iphone.chargeIphone();
    }
}
