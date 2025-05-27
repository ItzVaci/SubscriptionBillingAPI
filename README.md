# Subscription Billing & Payment API

A Spring Boot RESTful API for managing subscription plans, subscriptions, invoices, payment methods, and more.

## Authentication
All requests must include an API key in the header:
X-API-Key: abc123XYZ

Requests without a valid API key return 401 Unauthorized.

## Endpoints Overview

### Subscriptions
- POST /subscriptions – Create a new subscription
- GET /subscriptions/{id} – Get subscription by ID
- PATCH /subscriptions/{id} – Update billing cycle or status
- DELETE /subscriptions/{id} – Cancel a subscription

### Invoices
- GET /invoices/{id} – Get invoice by ID
- POST /invoices/{subscriptionId} – Generate invoice for a subscription

### Payment Methods
- POST /payment-methods – Add a new payment method
- GET /payment-methods/{customerId} – Get all payment methods for a customer

### Refunds
- POST /refunds/{invoiceId} – Issue prorated refund

### Trial Management
- PATCH /subscriptions/{id}/extend-trial – Extend trial period

## Sample Request

POST /subscriptions
{
  "customerId": "cust001",
  "planId": "planA1",
  "status": "ACTIVE",
  "startDate": "2025-06-01T00:00:00",
  "endDate": "2025-12-31T00:00:00",
  "trialDays": 14,
  "billingCycle": "MONTHLY"
}

## Technologies
- Java 17
- Spring Boot 3.1.0
- Maven
- Spring Data JPA
- H2 database

## Run the Application
mvn spring-boot:run

http://localhost:8080

## API Documentation
See the Postman collection for full endpoint usage.

## Author
Vlatko Angelov – Interface Programming Course Project
