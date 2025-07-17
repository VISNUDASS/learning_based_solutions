
interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amountInDollars) {
        System.out.println("Paid $" + amountInDollars + " using PayPal.");
    }
}

class StripeGateway {
    public void sendPayment(double amountInUSD) {
        System.out.println("Paid $" + amountInUSD + " using Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter() {
        this.payPalGateway = new PayPalGateway();
    }

    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter() {
        this.stripeGateway = new StripeGateway();
    }

    public void processPayment(double amount) {
        stripeGateway.sendPayment(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter();
        paypal.processPayment(100.0);

        PaymentProcessor stripe = new StripeAdapter();
        stripe.processPayment(250.0);
    }
}
