package com.example.subscriptionapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String customerId;
    private String type;
    private String details;

    public PaymentMethod() {
    }

    public PaymentMethod(String customerId, String type, String details) {
        this.customerId = customerId;
        this.type = type;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
