package com.example.subscriptionapi.repository;

import com.example.subscriptionapi.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
}
