package com.example.subscriptionapi.service;

import com.example.subscriptionapi.model.PaymentMethod;
import com.example.subscriptionapi.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {
    @Autowired
    private PaymentMethodRepository repository;

    public PaymentMethod add(PaymentMethod method) {
        return repository.save(method);
    }
}
