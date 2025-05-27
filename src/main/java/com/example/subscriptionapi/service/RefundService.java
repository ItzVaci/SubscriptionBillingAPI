package com.example.subscriptionapi.service;

import com.example.subscriptionapi.model.Refund;
import com.example.subscriptionapi.repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundService {
    @Autowired
    private RefundRepository repository;

    public Refund process(Refund refund) {
        return repository.save(refund);
    }
}
