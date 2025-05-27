package com.example.subscriptionapi.service;

import com.example.subscriptionapi.model.Subscription;
import com.example.subscriptionapi.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository repository;

    public Subscription create(Subscription s) {
        return repository.save(s);
    }

    public Optional<Subscription> get(String id) {
        return repository.findById(id);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
