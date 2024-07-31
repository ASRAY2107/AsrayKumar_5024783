public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.executePayment();

        context.setPaymentStrategy(new PayPalPayments());
        context.executePayment();
    }
}

interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paying with Credit Card");
    }
}

class PayPalPayments implements PaymentStrategy {
    public void pay() {
        System.out.println("Paying with PayPal");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment() {
        strategy.pay();
    }
}

