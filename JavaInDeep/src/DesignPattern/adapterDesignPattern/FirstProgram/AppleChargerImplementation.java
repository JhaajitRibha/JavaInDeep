package DesignPattern.adapterDesignPattern.FirstProgram;

public class AppleChargerImplementation implements AppleCharger{
    @Override
    public void chargePhone() {
        System.out.println("Iphone is getting charged ... ");
    }
}
