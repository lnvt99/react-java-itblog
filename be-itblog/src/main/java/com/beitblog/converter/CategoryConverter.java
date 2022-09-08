package com.beitblog.converter;

import com.beitblog.dto.CategoryDTO;
import com.beitblog.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
  public CategoryEntity toEntity(CategoryDTO dto) {
    CategoryEntity entity = new CategoryEntity();
    entity.setTitle(dto.getTitle());
    entity.setSlug(dto.getSlug());
    entity.setDescription(dto.getDescription());
    return entity;
  }

  public CategoryDTO toDTO(CategoryEntity entity) {
    CategoryDTO dto = new CategoryDTO();
    dto.setId(entity.getId());
    dto.setTitle(entity.getTitle());
    dto.setSlug(entity.getSlug());
    dto.setDescription(entity.getDescription());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setCreatedAt(entity.getCreatedAt());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setUpdatedAt(entity.getUpdatedAt());
    return dto;
  }

  public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity) {
    entity.setTitle(dto.getTitle());
    entity.setSlug(dto.getSlug());
    entity.setDescription(dto.getDescription());
    return entity;
  }
}
