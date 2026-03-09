interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class PaymentService {

    PaymentStrategy strategy;

    PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    void processPayment(int amount) {
        strategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {

        PaymentService service = new PaymentService(new CreditCardPayment());
        service.processPayment(500);

    }
}