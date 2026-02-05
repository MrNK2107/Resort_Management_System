package com.resortmanagement.system.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.hr.entity.Role;
import com.resortmanagement.system.hr.repository.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<Role> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public Role save(Role entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}
