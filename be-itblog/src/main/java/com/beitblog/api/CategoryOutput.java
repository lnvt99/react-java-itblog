package com.beitblog.api;

import com.beitblog.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryOutput {
  private int currentPage;
  private int totalPage;
  private List<CategoryDTO> categoryDTOList = new ArrayList<>();

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public List<CategoryDTO> getCategoryDTOList() {
    return categoryDTOList;
  }

  public void setCategoryDTOList(List<CategoryDTO> categoryDTOList) {
    this.categoryDTOList = categoryDTOList;
  }
}
