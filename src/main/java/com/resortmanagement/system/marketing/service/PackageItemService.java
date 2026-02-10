package com.resortmanagement.system.marketing.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resortmanagement.system.marketing.dto.PackageItemDTO;
import com.resortmanagement.system.marketing.entity.PackageItem;
import com.resortmanagement.system.marketing.repository.PackageItemRepository;
import com.resortmanagement.system.marketing.repository.PackageRepository;

@Service
@Transactional
public class PackageItemService {

    private final PackageItemRepository repository;
    private final PackageRepository packageRepository;

    public PackageItemService(
            PackageItemRepository repository,
            PackageRepository packageRepository) {
        this.repository = repository;
        this.packageRepository = packageRepository;
    }

    @Transactional(readOnly = true)
    public org.springframework.data.domain.Page<PackageItemDTO> findAll(
            org.springframework.data.domain.Pageable pageable) {
        return repository.findByDeletedFalse(pageable).map(this::toDTO);
    }

    @Transactional(readOnly = true)
    public Optional<PackageItemDTO> findById(UUID id) {
        return repository.findByIdAndDeletedFalse(id).map(this::toDTO);
    }

    public PackageItemDTO save(PackageItemDTO dto) {
        if (dto.getPkgId() == null) {
            throw new IllegalArgumentException("Package ID is required");
        }

        PackageItem entity = new PackageItem();

        // Resolve package
        entity.setPkg(packageRepository.findById(dto.getPkgId())
                .orElseThrow(() -> new IllegalArgumentException("Package not found")));

        // Set optional item IDs directly
        entity.setRoomTypeId(dto.getRoomTypeId());
        entity.setServiceItemId(dto.getServiceItemId());
        entity.setMenuItemId(dto.getMenuItemId());
        entity.setInventoryItemId(dto.getInventoryItemId());

        boolean hasItem = entity.getRoomTypeId() != null ||
                entity.getServiceItemId() != null ||
                entity.getMenuItemId() != null ||
                entity.getInventoryItemId() != null;

        if (!hasItem) {
            throw new IllegalArgumentException(
                    "At least one item reference (RoomType, ServiceItem, MenuItem, InventoryItem) is required");
        }

        if (dto.getQty() == null || dto.getQty() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        entity.setQty(dto.getQty());

        if (dto.getPrice() == null || dto.getPrice().compareTo(java.math.BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        entity.setPrice(dto.getPrice());

        return toDTO(repository.save(entity));
    }

    public PackageItemDTO update(UUID id, PackageItemDTO dto) {
        return repository.findByIdAndDeletedFalse(id)
                .map(existing -> {
                    // Update quantity and price
                    if (dto.getQty() != null)
                        existing.setQty(dto.getQty());
                    if (dto.getPrice() != null)
                        existing.setPrice(dto.getPrice());

                    // Update relationships if provided
                    if (dto.getPkgId() != null) {
                        existing.setPkg(packageRepository.findById(dto.getPkgId())
                                .orElseThrow(() -> new IllegalArgumentException("Package not found")));
                    }

                    if (dto.getRoomTypeId() != null)
                        existing.setRoomTypeId(dto.getRoomTypeId());
                    if (dto.getServiceItemId() != null)
                        existing.setServiceItemId(dto.getServiceItemId());
                    if (dto.getMenuItemId() != null)
                        existing.setMenuItemId(dto.getMenuItemId());
                    if (dto.getInventoryItemId() != null)
                        existing.setInventoryItemId(dto.getInventoryItemId());

                    return toDTO(repository.save(existing));
                })
                .orElseThrow(() -> new RuntimeException("PackageItem not found with id " + id));
    }

    public void deleteById(UUID id) {
        repository.softDeleteById(id, java.time.Instant.now());
    }

    // Simple DTO mapping
    private PackageItemDTO toDTO(PackageItem entity) {
        PackageItemDTO dto = new PackageItemDTO();
        dto.setId(entity.getId());
        dto.setPkgId(entity.getPkg() != null ? entity.getPkg().getId() : null);
        dto.setRoomTypeId(entity.getRoomTypeId());
        dto.setServiceItemId(entity.getServiceItemId());
        dto.setMenuItemId(entity.getMenuItemId());
        dto.setInventoryItemId(entity.getInventoryItemId());
        dto.setQty(entity.getQty());
        dto.setPrice(entity.getPrice());
        return dto;
    }
}
