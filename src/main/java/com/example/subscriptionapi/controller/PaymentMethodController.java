package com.example.subscriptionapi.controller;

import com.example.subscriptionapi.model.PaymentMethod;
import com.example.subscriptionapi.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService service;

    @PostMapping
    public ResponseEntity<PaymentMethod> add(@RequestBody PaymentMethod method) {
        return ResponseEntity.ok(service.add(method));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PaymentMethod>> getByCustomerId(@PathVariable String customerId) {
        List<PaymentMethod> methods = service.findByCustomerId(customerId);
        return ResponseEntity.ok(methods);
    }
}
