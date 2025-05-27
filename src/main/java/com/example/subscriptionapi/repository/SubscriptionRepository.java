package com.example.subscriptionapi.repository;

import com.example.subscriptionapi.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
}
