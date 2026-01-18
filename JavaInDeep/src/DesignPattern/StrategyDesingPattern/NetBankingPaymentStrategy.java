package DesignPattern.StrategyDesingPattern;

public class NetBankingPaymentStrategy implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using NetBanking");
    }
}

