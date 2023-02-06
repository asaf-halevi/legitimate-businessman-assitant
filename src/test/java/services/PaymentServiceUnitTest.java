package services;

import categories.UnitTest;
import entities.Payment;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import repo.PaymentRepository;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Category(UnitTest.class)
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
    public void createPaymentWithPositiveValue() {
        final long amount = 1000;

        Payment payment = null;
        String errorMessage = null;

        try {
            payment = paymentService.createPayment(1, amount);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        assertEquals(amount, payment.getAmount());
        assertNull(errorMessage);
    }

    @Test
    @Ignore
    public void createPaymentWithZeroValue() {
        final long amount = 0;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            paymentService.createPayment(1, amount);
        });

        assertNotNull(exception);
        assertNotNull(exception.getMessage());
    }

    @Test
    @Ignore
    public void createPaymentWithNegativeValue() {
        final long amount = -1;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            paymentService.createPayment(1, amount);
        });

        assertNotNull(exception);
        assertNotNull(exception.getMessage());
    }
}
