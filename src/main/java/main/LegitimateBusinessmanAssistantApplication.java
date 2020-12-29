package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import services.BusinessService;
import services.PaymentService;

@SpringBootApplication(scanBasePackages = {"controllers", "services", "repo", "entities"})
@EnableAutoConfiguration
@SpringBootConfiguration
@EntityScan(basePackages = {"entities"})
@EnableJpaRepositories(basePackages = {"repo"})
public class LegitimateBusinessmanAssistantApplication implements CommandLineRunner {

    @Autowired
    private BusinessService businessService;

    @Autowired
    private PaymentService paymentService;

    public static void main(String[] args) {
        SpringApplication.run(LegitimateBusinessmanAssistantApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createInitialdata();
    }

    private void createInitialdata() {
        businessService.createBusiness("Eshkol IceCream");
        businessService.createBusiness("Shalom Falafel");
        businessService.createBusiness("DruidsBeUs");
        paymentService.createAndSavePayment(1, 1000);
        paymentService.createAndSavePayment(2, 2000);
        paymentService.createAndSavePayment(3, 3000);
    }
}
