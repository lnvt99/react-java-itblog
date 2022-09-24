package com.beitblog.entity;

import com.beitblog.utility.Slug;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "slug", nullable = false, unique = true)
  private String slug;

  @Column(name = "description", nullable = true)
  private String description;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PostEntity> posts = new ArrayList<>();

  public String buildSlug() {
    return Slug.makeSlug(getTitle());
  }
}