package com.beitblog.entity;

import com.beitblog.utility.Slug;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity {
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "slug", nullable = false, unique = true)
  private String slug;

  @Column(name = "summary", columnDefinition="TEXT")
  private String summary;

  @Column(name = "content", columnDefinition="TEXT")
  private String content;

  @Column(name = "image_url", columnDefinition="TEXT")
  private String imageUrl;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "category_id", nullable = false)
  private CategoryEntity category;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "account_id", nullable = true)
  private AccountEntity account;

  @ManyToMany
  @JoinTable(name = "post_section", joinColumns = @JoinColumn(name = "post_id", nullable = true), inverseJoinColumns = @JoinColumn(name = "section_id", nullable = false))
  private List<SectionEntity> sections = new ArrayList<>();

  public String buildSlug() {
    return Slug.makeSlug(getTitle());
  }
}