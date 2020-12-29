package controllers;

//import entities.Payment;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertNotNull;

import entities.Payment;
import main.LegitimateBusinessmanAssistantApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {LegitimateBusinessmanAssistantApplication.class})
public class PaymentControllerIntegrationTest {

    @Autowired
    PaymentController paymentController;

    @Test
    public void addPaymentWithPositiveAmountShouldSucceed() {
        Payment result = paymentController.addPayment(1, 1000);
        assertNotNull(result);
    }

//    @Test
//    public void addPaymentWithZeroAmountShouldFail() {
//        Payment payment = null;
//        String errorMessage = null;
//        try {
//            payment = paymentController.addPayment(1, 0);
//        } catch (IllegalArgumentException e) {
//            errorMessage = e.getMessage();
//        }
//        assertNull(payment);
//        assertEquals(PaymentService.ERROR_MESSAGE, errorMessage);
//    }

//    @Test
//    public void addPaymentWithNegativeAmountShouldFail() {
//        Payment payment = null;
//        String errorMessage = null;
//        try {
//            payment = paymentController.addPayment(1, -1);
//        } catch (IllegalArgumentException e) {
//            errorMessage = e.getMessage();
//        }
//        assertNull(payment);
//        assertEquals(PaymentService.ERROR_MESSAGE, errorMessage);
//    }
}
