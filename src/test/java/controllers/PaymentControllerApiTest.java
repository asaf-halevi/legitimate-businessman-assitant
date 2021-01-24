package controllers;

import main.LegitimateBusinessmanAssistantApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {LegitimateBusinessmanAssistantApplication.class})
@AutoConfigureMockMvc
public class PaymentControllerApiTest {

    public static final String ADD_PAYMENT = "/addPayment/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addPaymentWithPositiveAmountShouldSucceed() throws Exception {
        this.mockMvc.perform(post(ADD_PAYMENT + "1/1000"))
                .andExpect(status().isOk());
    }

//    @Test
//    public void addPaymentWithZeroAmountShouldFail() throws Exception {
//        String message = null;
//        try {
//            this.mockMvc.perform(post(ADD_PAYMENT + "1/0"));
//        } catch (Exception e) {
//            message = e.getMessage();
//        }
//        assertNotNull(message);
//        assertTrue(message.contains(PaymentService.ERROR_MESSAGE));
//    }
//
//    @Test
//    public void addPaymentWithNegativeAmountShouldFail() throws Exception {
//        String message = null;
//        try {
//            this.mockMvc.perform(post(ADD_PAYMENT + "1/-1000"));
//        } catch (Exception e) {
//            message = e.getMessage();
//        }
//        assertNotNull(message);
//        assertTrue(message.contains(PaymentService.ERROR_MESSAGE));
//    }
}
