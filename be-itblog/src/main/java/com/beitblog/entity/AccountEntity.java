package com.beitblog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {
  @Column(name = "fullname", nullable = false)
  private String fullname;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PostEntity> posts = new ArrayList<>();

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<PostEntity> getPosts() {
    return posts;
  }

  public void setPosts(List<PostEntity> posts) {
    this.posts = posts;
  }
}