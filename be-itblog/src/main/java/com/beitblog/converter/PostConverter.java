package com.beitblog.converter;

import com.beitblog.dto.PostDTO;
import com.beitblog.entity.PostEntity;
import com.beitblog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
  @Autowired
  private ICategoryRepository iCategoryRepository;

  public PostEntity toEntity(PostDTO dto) {
    PostEntity entity = new PostEntity();
    entity.setTitle(dto.getTitle());
    entity.setSummary(dto.getSummary());
    entity.setContent(dto.getContent());
    entity.setImageUrl(dto.getImageUrl());
    entity.setCategory(iCategoryRepository.findOneBySlug(dto.getCategory()));
    return entity;
  }

  public PostDTO toDTO(PostEntity entity) {
    PostDTO dto = new PostDTO();
    dto.setTitle(entity.getTitle());
    dto.setSlug(entity.getSlug());
    dto.setSummary(entity.getSummary());
    dto.setContent(entity.getContent());
    dto.setImageUrl(entity.getImageUrl());
    dto.setCategory(iCategoryRepository.findById((long) entity.getCategory().getId()).getTitle());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setCreatedAt(entity.getCreatedAt());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setUpdatedAt(entity.getUpdatedAt());
    return dto;
  }

  public PostEntity toEntity(PostDTO dto, PostEntity entity) {
    entity.setTitle(dto.getTitle());
    entity.setSummary(dto.getSummary());
    entity.setContent(dto.getContent());
    entity.setImageUrl(dto.getImageUrl());
    entity.setCategory(iCategoryRepository.findOneBySlug(dto.getCategory()));
    return entity;
  }
}
