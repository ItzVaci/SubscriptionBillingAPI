package com.example.subscriptionapi.controller;

import com.example.subscriptionapi.model.Subscription;
import com.example.subscriptionapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping
    public ResponseEntity<Subscription> create(@RequestBody Subscription sub) {
        return ResponseEntity.ok(service.create(sub));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> get(@PathVariable String id) {
        Optional<Subscription> s = service.get(id);
        return s.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Subscription> updateSubscription(
            @PathVariable String id,
            @RequestBody Map<String, Object> updates) {
        Subscription updated = service.updateSubscription(id, updates);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}/trial")
    public ResponseEntity<Subscription> extendTrialPeriod(
            @PathVariable String id,
            @RequestBody Map<String, Integer> body) {
        Integer extraDays = body.get("extraDays");
        Subscription updated = service.extendTrialPeriod(id, extraDays);
        return ResponseEntity.ok(updated);
    }
}
