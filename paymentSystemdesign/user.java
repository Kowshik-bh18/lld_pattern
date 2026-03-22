import java.util.*;
interface payment {
    public void pay();
}

class upi implements payment{
    public void pay(){
        System.out.println("Paid through upi");
    }
}

class creditcard implements payment{
    public void pay(){
        System.out.println("Paid through creditcard");
    }
}


class debitcard implements payment{
    public void pay(){
        System.out.println("Paid through debitcard");
    }
}

class paymentfactory {
    public payment getpayment(String s){
        if(s.equals("upi")){
            return new upi();
        }

        else if(s.equals("credit")) {
            return new creditcard();
        }

        else if(s.equals("debit")){
            return new debitcard();
        }
        return null;
    }
}


public class user {
    public static void main(String []args){
        paymentfactory p1 = new paymentfactory();
        System.out.println("Enter the type of payment u want to make:");
        Scanner sc = new Scanner(System.in);
        String paytype = sc.next();
        payment user_request = p1.getpayment(paytype);
        if(user_request==null){
            System.out.println("wrong payment type");
        }
        else{
        user_request.pay();
        }
        sc.close();
    }
}

// improved version of above payment implementation with context class usage


/* 
import java.util.*;

// 1️⃣ Strategy Interface
interface Payment {
    void pay();
}

// 2️⃣ Concrete Strategies
class UpiPayment implements Payment {
    public void pay() {
        System.out.println("Paid through UPI");
    }
}

class CreditCardPayment implements Payment {
    public void pay() {
        System.out.println("Paid through Credit Card");
    }
}

class DebitCardPayment implements Payment {
    public void pay() {
        System.out.println("Paid through Debit Card");
    }
}

// 3️⃣ Factory (Improved - No if-else, uses Map)
class PaymentFactory {

    private static final Map<String, Payment> paymentMap = new HashMap<>();

    static {
        paymentMap.put("upi", new UpiPayment());
        paymentMap.put("credit", new CreditCardPayment());
        paymentMap.put("debit", new DebitCardPayment());
    }

    public static Payment getPayment(String type) {
        Payment payment = paymentMap.get(type.toLowerCase());

        if (payment == null) {
            throw new IllegalArgumentException("Invalid payment type");
        }

        return payment;
    }
}

// 4️⃣ Context Class
class PaymentService {

    private Payment payment;

    public PaymentService(Payment payment) {
        this.payment = payment;
    }

    public void processPayment() {

        // Pre-processing logic
        System.out.println("Validating payment...");

        // Execute strategy
        payment.pay();

        // Post-processing logic
        System.out.println("Payment successful!");
    }
}

// 5️⃣ Client
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter payment type (upi / credit / debit): ");
        String type = sc.next();

        try {
            // Factory → Strategy
            Payment payment = PaymentFactory.getPayment(type);

            // Context
            PaymentService service = new PaymentService(payment);

            // Execute
            service.processPayment();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}

*/