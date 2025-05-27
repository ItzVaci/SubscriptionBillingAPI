package com.example.subscriptionapi.service;

import com.example.subscriptionapi.model.PaymentMethod;
import com.example.subscriptionapi.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository repo;

    public PaymentMethod add(PaymentMethod method) {
        return repo.save(method);
    }

    public List<PaymentMethod> findByCustomerId(String customerId) {
        return repo.findByCustomerId(customerId);
    }
}
