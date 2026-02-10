package com.resortmanagement.system.marketing.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resortmanagement.system.marketing.dto.packagedto.PackageRequest;
import com.resortmanagement.system.marketing.dto.packagedto.PackageResponse;
import com.resortmanagement.system.marketing.entity.Package;
import com.resortmanagement.system.marketing.mapper.PackageMapper;
import com.resortmanagement.system.marketing.repository.PackageRepository;

@Service
@Transactional
public class PackageService {

    private final PackageRepository repository;
    private final PackageMapper mapper;

    public PackageService(PackageRepository packageRepository, PackageMapper packageMapper) {
        this.repository = packageRepository;
        this.mapper = packageMapper;
    }

    @Transactional(readOnly = true)
    public Page<PackageResponse> findAll(Pageable pageable) {
        return repository.findByDeletedFalse(pageable).map(mapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Optional<PackageResponse> findById(UUID id) {
        return repository.findByIdAndDeletedFalse(id).map(mapper::toResponse);
    }

    public PackageResponse save(PackageRequest dto) {
        if (dto.getName() == null || dto.getName().isEmpty()) {
            throw new IllegalArgumentException("Package name is required");
        }
        if (dto.getPrice() == null) {
            throw new IllegalArgumentException("Package price is required");
        }

        Package pkg = mapper.toEntity(dto);
        Package saved = repository.save(pkg);
        return mapper.toResponse(saved);
    }

    public PackageResponse update(UUID id, PackageRequest dto) {
        return repository.findByIdAndDeletedFalse(id)
                .map(existing -> {
                    mapper.updateEntity(existing, dto);
                    return mapper.toResponse(repository.save(existing));
                })
                .orElseThrow(() -> new RuntimeException("Package not found with id " + id));
    }

    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Package not found with id " + id);
        }
        repository.softDeleteById(id, Instant.now());
    }
}
