package services;

public interface PaymentService {

    double interestRate(double amount, int months);

    double paymentFee(double amount);

}
