package com.example.subscriptionapi.service;

import com.example.subscriptionapi.model.Subscription;
import com.example.subscriptionapi.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository repo;

    public Subscription extendTrialPeriod(String id, int extraDays) {
        Optional<Subscription> optional = repo.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Subscription not found");
        }

        Subscription sub = optional.get();
        sub.setTrialDays(sub.getTrialDays() + extraDays);
        return repo.save(sub);
    }


    public Subscription create(Subscription s) {
        return repo.save(s);
    }

    public Optional<Subscription> get(String id) {
        return repo.findById(id);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public Subscription updateSubscription(String id, Map<String, Object> updates) {
        Optional<Subscription> optional = repo.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Subscription not found");
        }

        Subscription sub = optional.get();

        if (updates.containsKey("billingCycle")) {
            sub.setBillingCycle((String) updates.get("billingCycle"));
        }
        if (updates.containsKey("status")) {
            sub.setStatus((String) updates.get("status"));
        }
        if (updates.containsKey("trialDays")) {
            sub.setTrialDays((Integer) updates.get("trialDays"));
        }
        if (updates.containsKey("endDate")) {
            sub.setEndDate(LocalDateTime.parse((String) updates.get("endDate")));
        }


        return repo.save(sub);
    }
}
