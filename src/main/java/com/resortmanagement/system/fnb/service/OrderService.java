package com.resortmanagement.system.fnb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.fnb.entity.Order;
import com.resortmanagement.system.fnb.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<Order> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public Order save(Order entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}
