package com.example.subscriptionapi.controller;

import com.example.subscriptionapi.model.Refund;
import com.example.subscriptionapi.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refunds")
public class RefundController {
    @Autowired
    private RefundService service;

    @PostMapping
    public ResponseEntity<Refund> refund(@RequestBody Refund refund) {
        return ResponseEntity.ok(service.process(refund));
    }
}
