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

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addPaymentWithPositiveAmountShouldSucceed() {
        try {
            this.mockMvc.perform(post("/addPayment/1/1000"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void addPaymentWithZeroAmountShouldFail() {
//        try {
//            this.mockMvc.perform(post("/addPayment/1/0"))
//                    .andExpect(status().isBadRequest());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void addPaymentWithNegativeAmountShouldFail() {
//        try {
//            this.mockMvc.perform(post("/addPayment/1/-1000"))
//                    .andExpect(status().isBadRequest());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}