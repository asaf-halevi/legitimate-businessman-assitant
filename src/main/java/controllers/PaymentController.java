package controllers;

import entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import services.PaymentService;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "addPayment/{businessId}/{amount}")
    public @ResponseBody Payment addPayment(@PathVariable Integer businessId, @PathVariable long amount) {
        return paymentService.createAndSavePayment(businessId, amount);
    }
}
