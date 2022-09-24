package com.beitblog.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @Setter(AccessLevel.NONE)
  private Long id;

  @Column(name = "created_by")
  @CreatedBy
  private Long createdBy;

  @Column(name = "created_at", nullable = false)
  @CreatedDate
  private Date createdAt;

  @Column(name = "updated_by")
  @LastModifiedBy
  private Long updatedBy;

  @Column(name = "updated_at", nullable = false)
  @LastModifiedDate
  private Date updatedAt;
}