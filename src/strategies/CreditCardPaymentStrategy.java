package strategies;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        // Logic to process credit card payment
        System.out.println("Processing credit card payment of " + amount + " using card: " + cardNumber);
        // Here you would integrate with a credit card payment gateway
    }

}
