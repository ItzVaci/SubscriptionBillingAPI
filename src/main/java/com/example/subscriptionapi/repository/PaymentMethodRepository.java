package com.example.subscriptionapi.repository;

import com.example.subscriptionapi.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, String> {
    List<PaymentMethod> findByCustomerId(String customerId);
}
