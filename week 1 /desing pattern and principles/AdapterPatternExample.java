public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor processor = new PayPalAdapter(new PayPalPayment());
        processor.processPayment();

        processor = new StripeAdapter(new StripePayment());
        processor.processPayment();
    }
}

interface PaymentProcessor {
    void processPayment();
}

class PayPalPayment {
    public void makePayment() {
        System.out.println("Processing payment through PayPal");
    }
}

class StripePayment {
    public void pay() {
        System.out.println("Processing payment through Stripe");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalPayment payPalPayment;

    public PayPalAdapter(PayPalPayment payPalPayment) {
        this.payPalPayment = payPalPayment;
    }

    public void processPayment() {
        payPalPayment.makePayment();
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    public void processPayment() {
        stripePayment.pay();
    }
}
