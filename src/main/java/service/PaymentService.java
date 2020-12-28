package service;

import model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.PaymentRepository;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Integer businessId, long amount) {
//        if (amount <= 0) {
//            throw new IllegalArgumentException("Make me an offer I can\'t refuse!");
//        }
        return paymentRepository.save(new Payment(businessId, amount));
    }

    public Iterable<Payment> lookup() {
        return paymentRepository.findAll();
    }
}
