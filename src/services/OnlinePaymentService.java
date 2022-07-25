package services;

import entities.Contract;
import entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class OnlinePaymentService {

    private PaymentService paymentService;

    public OnlinePaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract (Contract contract,int months){
        double initialValue = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            double updatedValue = initialValue + paymentService.interestRate(initialValue, i);
            double fullQuota = updatedValue + paymentService.paymentFee(updatedValue);
            Date dueDate = addMonths(contract.getDate(), i);
            contract.getInstallments().add(new Installment(dueDate,fullQuota));
        }
    }

    public Date addMonths (Date date, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }
}
