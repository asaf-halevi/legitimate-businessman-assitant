package controllers;

import categories.ApiTest;
import main.LegitimateBusinessmanAssistantApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;
import services.PaymentService;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes =
        {LegitimateBusinessmanAssistantApplication.class})
@AutoConfigureMockMvc
@Category(ApiTest.class)
public class PaymentControllerApiTest {

    public static final String ADD_PAYMENT = "/addPayment/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addPaymentWithPositiveAmountShouldSucceed() throws Exception {
        this.mockMvc.perform(post(ADD_PAYMENT + "1/1000"))
                    .andExpect(status().isOk());
    }

    @Test
    @Ignore
    public void addPaymentWithZeroAmountShouldFail() {
        Exception exception = assertThrows(NestedServletException.class, () -> {
            this.mockMvc.perform(post(ADD_PAYMENT + "1/0"));
        });

        assertNotNull(exception);
        assertTrue(exception.getMessage().contains(PaymentService.ERROR_MESSAGE));
    }

    @Test
    @Ignore
    public void addPaymentWithNegativeAmountShouldFail() {
        Exception exception = assertThrows(NestedServletException.class, () -> {
            this.mockMvc.perform(post(ADD_PAYMENT + "1/-1000"));
        });

        assertNotNull(exception);
        assertTrue(exception.getMessage().contains(PaymentService.ERROR_MESSAGE));
    }
}
