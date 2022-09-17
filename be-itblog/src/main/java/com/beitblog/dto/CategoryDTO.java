package com.beitblog.dto;

import lombok.Data;

@Data
public class CategoryDTO extends BaseDTO {
  private String title;
  private String slug;
  private String description;
}
