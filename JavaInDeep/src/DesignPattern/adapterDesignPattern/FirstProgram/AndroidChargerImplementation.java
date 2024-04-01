package DesignPattern.adapterDesignPattern.FirstProgram;

public class AndroidChargerImplementation implements AndroidCharger{
    @Override
    public void chargePhone() {
        System.out.println("Android phone is getting charged ");
    }
}
