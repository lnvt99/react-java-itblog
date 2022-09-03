package com.beitblog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class SectionEntity extends BaseEntity {
  @Column(name = "title", nullable = false)
  private String title;

  @ManyToMany(mappedBy = "sections")
  private List<PostEntity> posts = new ArrayList<>();

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<PostEntity> getPosts() {
    return posts;
  }

  public void setPosts(List<PostEntity> posts) {
    this.posts = posts;
  }
}
