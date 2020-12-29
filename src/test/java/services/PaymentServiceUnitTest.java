package services;

import entities.Payment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import repo.PaymentRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PaymentServiceUnitTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createPaymentWithValidValue() {
        Payment paymentMock = new Payment(1, 1000);

        Payment payment = null;
        String errorMessage = null;

        when(paymentRepository.save(any(Payment.class))).thenReturn(paymentMock);

        try {
            payment = paymentService.createPayment(1, 1000);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        assertEquals(paymentMock.getAmount(), payment.getAmount());
        assertNull(errorMessage);
    }

}
