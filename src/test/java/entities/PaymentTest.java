package entities;

import categories.ComponentTest;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Category(ComponentTest.class)
class PaymentTest {
    @Test
    void testConstructor() {
        assertEquals("Payment{id=null, businessId=null, amount=0}", (new Payment()).toString());
    }

    @Test
    void testConstructor2() {
        Payment actualPayment = new Payment();
        actualPayment.setAmount(10L);
        actualPayment.setBusinessId(123);
        actualPayment.setId(1);
        assertEquals(10L, actualPayment.getAmount());
        assertEquals(123, actualPayment.getBusinessId().intValue());
        assertEquals(1, actualPayment.getId().intValue());
        assertEquals("Payment{id=1, businessId=123, amount=10}", actualPayment.toString());
    }
}

