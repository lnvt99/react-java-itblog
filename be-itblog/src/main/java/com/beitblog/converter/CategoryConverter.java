package com.beitblog.converter;

import com.beitblog.dto.CategoryDTO;
import com.beitblog.entity.CategoryEntity;
import com.beitblog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
  @Autowired
  private ICategoryRepository iCategoryRepository;

  public CategoryEntity toEntity(CategoryDTO dto) {
    CategoryEntity entity = new CategoryEntity();
    entity.setTitle(dto.getTitle());
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
    entity.setDescription(dto.getDescription());
    return entity;
  }
}
