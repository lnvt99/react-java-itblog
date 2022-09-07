package com.beitblog.repository;

import com.beitblog.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepository extends JpaRepository<PostEntity, Long> {
  List<PostEntity> findByTitleContaining(String title);
  PostEntity findById(long id);
}
