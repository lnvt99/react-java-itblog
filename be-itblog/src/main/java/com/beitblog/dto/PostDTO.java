package com.beitblog.dto;

import lombok.Data;

@Data
public class PostDTO extends BaseDTO {
  private String title;
  private String slug;
  private String summary;
  private String content;
  private String imageUrl;
  private String category;
  private String user;
}
