package DesignPattern.StrategyDesingPattern;

public class UpiPaymentStrategy implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

