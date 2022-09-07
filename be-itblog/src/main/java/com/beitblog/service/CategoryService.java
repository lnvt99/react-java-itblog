package com.beitblog.service;

import com.beitblog.converter.CategoryConverter;
import com.beitblog.dto.CategoryDTO;
import com.beitblog.entity.CategoryEntity;
import com.beitblog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
  @Autowired
  private ICategoryRepository iCategoryRepository;

  @Autowired
  private CategoryConverter categoryConverter;

  @Override
  public int count() {
    return (int) iCategoryRepository.count();
  }

  @Override
  public List<CategoryDTO> findAll() {
    List<CategoryDTO> categoryDTOList = new ArrayList<>();
    List<CategoryEntity> categoryEntityList = iCategoryRepository.findAll();
    for (CategoryEntity entity: categoryEntityList) {
      CategoryDTO categoryDTO = categoryConverter.toDTO(entity);
      categoryDTOList.add(categoryDTO);
    }
    return categoryDTOList;
  }

  @Override
  public List<CategoryDTO> findAll(Pageable pageable) {
    List<CategoryDTO> categoryDTOList = new ArrayList<>();
    List<CategoryEntity> categoryEntityList = iCategoryRepository.findAll(pageable).getContent();
    for (CategoryEntity entity: categoryEntityList) {
      CategoryDTO categoryDTO = categoryConverter.toDTO(entity);
      categoryDTOList.add(categoryDTO);
    }
    return categoryDTOList;
  }

  @Override
  public List<CategoryDTO> findByTitle(String title) {
    List<CategoryEntity> categoryEntityList = iCategoryRepository.findByTitleContaining(title);
    List<CategoryDTO> categoryDTOList = new ArrayList<>();
    for (CategoryEntity categoryEntity: categoryEntityList) {
      categoryDTOList.add(categoryConverter.toDTO(categoryEntity));
    }
    return categoryDTOList;
  }

  @Override
  public CategoryDTO findById(long id) {
    CategoryEntity categoryEntity = iCategoryRepository.findById(id);
    return categoryConverter.toDTO(categoryEntity);
  }

  @Override
  public CategoryDTO save(CategoryDTO categoryDTO) {
    CategoryEntity categoryEntity;
    if (categoryDTO.getId() != null) {
      CategoryEntity oldCategoryEntity = iCategoryRepository.findById(categoryDTO.getId()).get();
      categoryEntity = categoryConverter.toEntity(categoryDTO, oldCategoryEntity);
    } else {
      categoryEntity = categoryConverter.toEntity(categoryDTO);
    }
    categoryEntity = iCategoryRepository.save(categoryEntity);
    return categoryConverter.toDTO(categoryEntity);
  }

  @Override
  public void delete(long[] ids) {
    for (Long id: ids) {
      iCategoryRepository.deleteById(id);
    }
  }
}
