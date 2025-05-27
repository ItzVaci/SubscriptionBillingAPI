package com.example.subscriptionapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String invoiceId;
    private double amount;
    private LocalDateTime refundedAt;
    private String reason;
}
