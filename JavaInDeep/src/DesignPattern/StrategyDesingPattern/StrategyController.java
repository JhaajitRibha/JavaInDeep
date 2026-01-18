package DesignPattern.StrategyDesingPattern;

public class StrategyController {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CardPaymentStrategy());
        context.executePayment(1000);

        context.setStrategy(new UpiPaymentStrategy());
        context.executePayment(500);
    }
}
