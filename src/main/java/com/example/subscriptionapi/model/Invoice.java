package com.example.subscriptionapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String subscriptionId;
    private String status; // Paid, Unpaid, Overdue
    private double amount;
    private String pdfUrl;
    private LocalDateTime issuedAt;
}
