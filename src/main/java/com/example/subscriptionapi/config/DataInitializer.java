package com.example.subscriptionapi.config;

import com.example.subscriptionapi.model.PaymentMethod;
import com.example.subscriptionapi.model.Subscription;
import com.example.subscriptionapi.repository.PaymentMethodRepository;
import com.example.subscriptionapi.repository.SubscriptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(SubscriptionRepository subscriptionRepo, PaymentMethodRepository paymentRepo) {
        return args -> {

            Subscription s1 = new Subscription();
            s1.setCustomerId("cust001");
            s1.setPlanId("plan001");
            s1.setStatus("ACTIVE");
            s1.setStartDate(LocalDateTime.of(2025, 6, 1, 0, 0));
            s1.setEndDate(LocalDateTime.of(2025, 12, 31, 0, 0));
            s1.setTrialDays(14);
            s1.setBillingCycle("MONTHLY");

            Subscription s2 = new Subscription();
            s2.setCustomerId("cust002");
            s2.setPlanId("plan002");
            s2.setStatus("ACTIVE");
            s2.setStartDate(LocalDateTime.of(2025, 6, 15, 0, 0));
            s2.setEndDate(LocalDateTime.of(2025, 12, 15, 0, 0));
            s2.setTrialDays(7);
            s2.setBillingCycle("YEARLY");

            subscriptionRepo.save(s1);
            subscriptionRepo.save(s2);

            PaymentMethod m1 = new PaymentMethod();
            m1.setCustomerId("cust001");
            m1.setType("CREDIT_CARD");
            m1.setDetails("**** **** **** 1234");

            PaymentMethod m2 = new PaymentMethod();
            m2.setCustomerId("cust002");
            m2.setType("PAYPAL");
            m2.setDetails("user@example.com");

            paymentRepo.save(m1);
            paymentRepo.save(m2);
        };
    }
}
