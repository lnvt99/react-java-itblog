package com.beitblog.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseDTO {
  private Long id;
  private Long createdBy;
  private Date createdAt;
  private Long updatedBy;
  private Date updatedAt;
}
