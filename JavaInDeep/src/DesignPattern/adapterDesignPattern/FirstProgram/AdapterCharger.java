package DesignPattern.adapterDesignPattern.FirstProgram;

public class AdapterCharger implements AppleCharger{

    private AndroidCharger charger;

    private AppleCharger chargerTwo;

    boolean flag = false;


    AdapterCharger(AndroidCharger charger){
        this.charger = charger;
    }

    AdapterCharger(AppleCharger charger,boolean flag){
        this.chargerTwo = charger;
        this.flag = flag;
    }
    @Override
    public void chargePhone() {

        if(!flag){
        System.out.println("charging through adapter ..");
        charger.chargePhone();
        }else{
            System.out.println("charging through adapter ..");
            chargerTwo.chargePhone();
        }

    }
}
