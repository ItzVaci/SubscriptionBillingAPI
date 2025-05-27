package com.example.subscriptionapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String customerId;
    private String planId;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int trialDays;
    private String billingCycle;
}
