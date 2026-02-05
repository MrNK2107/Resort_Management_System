package com.resortmanagement.system.inventory.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.resortmanagement.system.inventory.repository.PurchaseOrderRepository;
import com.resortmanagement.system.inventory.entity.PurchaseOrder;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository repository;

    public PurchaseOrderService(PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseOrder> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<PurchaseOrder> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public PurchaseOrder save(PurchaseOrder entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}
