package com.beitblog.entity;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity {
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "path", nullable = false)
  private String path;

  @Column(name = "summary", columnDefinition="TEXT")
  private String summary;

  @Column(name = "content", columnDefinition="TEXT")
  private String content;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "category_id", nullable = false)
  private CategoryEntity category;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "account_id", nullable = false)
  private AccountEntity account;

  @ManyToMany
  @JoinTable(name = "post_section", joinColumns = @JoinColumn(name = "post_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "section_id", nullable = false))
  private List<SectionEntity> sections = new ArrayList<>();

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
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