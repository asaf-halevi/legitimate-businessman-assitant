package services;

import entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.PaymentRepository;

@Service
public class PaymentService {

    public static final String ERROR_MESSAGE = "Make me an offer I can\'t refuse!";

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createAndSavePayment(Integer businessId, long amount) {
        return paymentRepository.save(createPayment(businessId, amount));
    }

    protected Payment createPayment(Integer businessId, long amount) throws IllegalArgumentException {
//        if (amount <= 0) {
//            throw new IllegalArgumentException(ERROR_MESSAGE);
//        }
        return new Payment(businessId, amount);
    }

    public Iterable<Payment> lookup() {
        return paymentRepository.findAll();
    }
}
