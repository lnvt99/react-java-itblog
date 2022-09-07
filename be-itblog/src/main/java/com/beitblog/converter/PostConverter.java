package com.beitblog.converter;

import com.beitblog.dto.PostDTO;
import com.beitblog.entity.PostEntity;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
  public PostEntity toEntity(PostDTO dto) {
    PostEntity entity = new PostEntity();
    entity.setTitle(dto.getTitle());
    entity.setPath(dto.getPath());
    entity.setSummary(dto.getSummary());
    entity.setContent(dto.getContent());
    return entity;
  }

  public PostDTO toDTO(PostEntity entity) {
    PostDTO dto = new PostDTO();
    dto.setTitle(entity.getTitle());
    dto.setPath(entity.getPath());
    dto.setSummary(entity.getSummary());
    dto.setContent(entity.getContent());
    return dto;
  }

  public PostEntity toEntity(PostDTO dto, PostEntity entity) {
    entity.setTitle(dto.getTitle());
    entity.setPath(dto.getPath());
    entity.setSummary(dto.getSummary());
    entity.setContent(dto.getContent());
    return entity;
  }
}
