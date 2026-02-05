package com.resortmanagement.system.fnb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.fnb.entity.OrderItem;
import com.resortmanagement.system.fnb.repository.OrderItemRepository;

@Service
public class OrderItemService {

    private final OrderItemRepository repository;

    public OrderItemService(OrderItemRepository repository) {
        this.repository = repository;
    }

    public List<OrderItem> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<OrderItem> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public OrderItem save(OrderItem entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}
