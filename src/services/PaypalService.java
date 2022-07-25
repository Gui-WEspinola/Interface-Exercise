package services;

public class PaypalService implements PaymentService {

    private static final double monthlyInterest = 0.01;
    private static final double paymentFee = 0.02;

    @Override
    public double interestRate(double amount, int months) {
        return amount * months * monthlyInterest;
    }

    @Override
    public double paymentFee(double amount) {
        return amount * paymentFee;
    }
}

