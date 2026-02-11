package com.resortmanagement.system.marketing.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resortmanagement.system.marketing.dto.promotion.PromotionRequest;
import com.resortmanagement.system.marketing.dto.promotion.PromotionResponse;
import com.resortmanagement.system.marketing.entity.Promotion;
import com.resortmanagement.system.marketing.mapper.PromotionMapper;
import com.resortmanagement.system.marketing.repository.PromotionRepository;

@Service
@Transactional
public class PromotionService {

    private final PromotionRepository repository;
    private final PromotionMapper mapper;

    public PromotionService(PromotionRepository promotionRepository, PromotionMapper promotionMapper) {
        this.repository = promotionRepository;
        this.mapper = promotionMapper;
    }

    @Transactional(readOnly = true)
    public Page<PromotionResponse> findAll(Pageable pageable) {
        return repository.findByDeletedFalse(pageable).map(mapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Optional<PromotionResponse> findById(UUID id) {
        return repository.findByIdAndDeletedFalse(id).map(mapper::toResponse);
    }

    public PromotionResponse save(PromotionRequest dto) {
        if (dto.getCode() == null || dto.getCode().isEmpty()) {
            throw new IllegalArgumentException("Promotion code is required");
        }
        if (dto.getValidFrom() == null || dto.getValidTo() == null) {
            throw new IllegalArgumentException("Valid from/to dates are required");
        }

        Promotion promotion = mapper.toEntity(dto);
        Promotion saved = repository.save(promotion);
        return mapper.toResponse(saved);
    }

    public PromotionResponse update(UUID id, PromotionRequest dto) {
        return repository.findByIdAndDeletedFalse(id)
                .map(existing -> {
                    mapper.updateEntity(existing, dto);
                    return mapper.toResponse(repository.save(existing));
                })
                .orElseThrow(() -> new RuntimeException("Promotion not found with id " + id));
    }

    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Promotion not found with id " + id);
        }
        repository.softDeleteById(id, Instant.now());
    }
}
