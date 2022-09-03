package com.beitblog.api;

import com.beitblog.dto.CategoryDTO;
import com.beitblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CategoryAPI {
  @Autowired
  private ICategoryService iCategoryService;

  @GetMapping(value = "/categories")
  public CategoryOutput get(
    @RequestParam(value = "page", required = false) Integer page,
    @RequestParam(value = "limit", required = false) Integer limit
  ) {
    CategoryOutput categoryOutput = new CategoryOutput();
    if (page != null && limit != null) {
      categoryOutput.setCurrentPage(page);
      Pageable pageable = PageRequest.of(page - 1, limit);
      categoryOutput.setCategoryDTOList(iCategoryService.findAll(pageable));
      categoryOutput.setTotalPage((int) Math.ceil((double) (iCategoryService.count()) / limit));
    } else {
      categoryOutput.setCategoryDTOList(iCategoryService.findAll());
    }
    return categoryOutput;
  }

  @GetMapping(value = "/category", params = "title")
  public List<CategoryDTO> get(@RequestParam String title) {
    return iCategoryService.findByTitle(title);
  }

  @PostMapping(value = "/category")
  public CategoryDTO store(@RequestBody CategoryDTO categoryDTO) {
    return iCategoryService.save(categoryDTO);
  }

  @GetMapping(value = "/category/{id}")
  public CategoryDTO show(@PathVariable("id") long id) {
    return iCategoryService.findById(id);
  }

  @PutMapping(value = "/category/{id}")
  public CategoryDTO update(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") long id) {
    categoryDTO.setId(id);
    return iCategoryService.save(categoryDTO);
  }

  @DeleteMapping(value = "/category")
  public void delete(@RequestBody long[] ids) {
    iCategoryService.delete(ids);
  }
}