package com.beitblog.service;

import com.beitblog.dto.CategoryDTO;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ICategoryService {
  int count();
  List<CategoryDTO> findAll();
  List<CategoryDTO> findAll(Pageable pageable);
  List<CategoryDTO> findByTitle(String title);
  CategoryDTO save(CategoryDTO categoryDTO);
  void delete(long[] ids);
}
