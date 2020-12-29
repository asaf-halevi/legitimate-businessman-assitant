package services;

import entities.Payment;
import main.LegitimateBusinessmanAssistantApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE, classes = {LegitimateBusinessmanAssistantApplication.class})
public class PaymentServiceIntegrationTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void testAddContactHappyPath() {

        final Integer businessId = 1;
        final long amount = 1000;

        // Test adding a payment
        Payment payment = paymentService.createPayment(businessId, amount);

        // Verify the addition
        assertNotNull(payment);
        assertEquals(businessId, payment.getBusinessId());
        assertEquals(amount, payment.getAmount());
    }
}
