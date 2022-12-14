package com.beitblog.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "section")
public class SectionEntity extends BaseEntity {
  @Column(name = "title", nullable = false)
  private String title;

  @ManyToMany(mappedBy = "sections")
  private List<PostEntity> posts = new ArrayList<>();
}
