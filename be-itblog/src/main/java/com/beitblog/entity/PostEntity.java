package com.beitblog.entity;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity {
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "slug", nullable = false)
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public CategoryEntity getCategory() {
    return category;
  }

  public void setCategory(CategoryEntity category) {
    this.category = category;
  }

  public AccountEntity getAccount() {
    return account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  public List<SectionEntity> getSections() {
    return sections;
  }

  public void setSections(List<SectionEntity> sections) {
    this.sections = sections;
  }
}