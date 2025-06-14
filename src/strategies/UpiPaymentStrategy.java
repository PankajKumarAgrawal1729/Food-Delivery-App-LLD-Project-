package strategies;

public class UpiPaymentStrategy implements PaymentStrategy {
    private String upiId;

    public UpiPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        // Logic to process UPI payment
        System.out.println("Processing UPI payment of " + amount + " using UPI ID: " + upiId);
        // Here you would integrate with a UPI payment gateway
    }
}
