package com.beitblog.repository;

import com.beitblog.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
  List<CategoryEntity> findByTitleContaining(String title);
  CategoryEntity findById(long id);
  CategoryEntity findOneBySlug(String slug);
  boolean existsBySlug(String slug);
}
