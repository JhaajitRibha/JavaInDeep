package DesignPattern.StrategyDesingPattern;

public class CardPaymentStrategy implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

