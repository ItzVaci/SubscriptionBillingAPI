package com.example.subscriptionapi.controller;

import com.example.subscriptionapi.model.PaymentMethod;
import com.example.subscriptionapi.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService service;

    @PostMapping
    public ResponseEntity<PaymentMethod> add(@RequestBody PaymentMethod method) {
        return ResponseEntity.ok(service.add(method));
    }
}
