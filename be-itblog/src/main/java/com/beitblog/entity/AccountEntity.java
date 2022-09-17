package com.beitblog.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

@Data
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
}