package services;

import entities.Business;
import main.LegitimateBusinessmanAssistantApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {LegitimateBusinessmanAssistantApplication.class})
public class BusinessServiceComponentTest {

    @Autowired
    private BusinessService businessService;

    @Test
    public void testLookup() {
        // Test get all businesses
        Iterable<Business> businesses = businessService.lookup();

        // Verify the addition
        assertNotNull(businesses);
    }

    @Test
    public void testCreateBusiness() {
        final String businessName = "DD-Tours";

        // Test adding a business
        Business business = businessService.createBusiness(businessName);

        // Verify the addition
        assertNotNull(business);
        assertEquals(businessName, business.getName());
    }
}
