package com.example.subscriptionapi.repository;

import com.example.subscriptionapi.model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRepository extends JpaRepository<Refund, String> {
}
