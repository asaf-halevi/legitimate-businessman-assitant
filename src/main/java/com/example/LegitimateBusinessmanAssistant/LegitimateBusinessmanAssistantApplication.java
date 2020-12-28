package com.example.LegitimateBusinessmanAssistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import service.BusinessService;
import service.PaymentService;

@SpringBootApplication(scanBasePackages = {"service", "repo", "model"})
@EnableAutoConfiguration
@EntityScan(basePackages = {"model"})
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
        paymentService.createPayment(1, 1000);
        paymentService.createPayment(2, 2000);
        paymentService.createPayment(3, 3000);
    }

}
