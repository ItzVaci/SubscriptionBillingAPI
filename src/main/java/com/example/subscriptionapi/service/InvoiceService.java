package com.example.subscriptionapi.service;

import com.example.subscriptionapi.model.Invoice;
import com.example.subscriptionapi.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository repository;

    public Invoice create(Invoice invoice) {
        return repository.save(invoice);
    }

    public Optional<Invoice> get(String id) {
        return repository.findById(id);
    }
}
