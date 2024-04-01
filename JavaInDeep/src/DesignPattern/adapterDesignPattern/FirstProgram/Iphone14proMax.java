package DesignPattern.adapterDesignPattern.FirstProgram;

public class Iphone14proMax {

    AppleCharger iphoneCharger;

    Iphone14proMax(AppleCharger appleCharger){
        this.iphoneCharger=appleCharger;
    }


    public void chargeIphone(){

        iphoneCharger.chargePhone();
    }

}
