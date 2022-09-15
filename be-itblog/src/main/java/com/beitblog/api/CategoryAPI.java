package com.beitblog.api;

import com.beitblog.dto.CategoryDTO;
import com.beitblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/category")
public class CategoryAPI {
  @Autowired
  private ICategoryService iCategoryService;

  @GetMapping(value = "")
  public ResponseEntity<ResponseAPI> get(
    @RequestParam(value = "page", required = false) Integer page,
    @RequestParam(value = "limit", required = false) Integer limit
  ) {
    CategoryOutput categoryOutput = new CategoryOutput();

    page = page != null ? page : 1;
    limit = limit != null ? limit : 10;

    categoryOutput.setCurrentPage(page);
    Pageable pageable = PageRequest.of(page - 1, limit);
    categoryOutput.setCategoryDTOList(iCategoryService.findAll(pageable));
    categoryOutput.setTotalPage((int) Math.ceil((double) (iCategoryService.count()) / limit));
    return ResponseEntity.status(HttpStatus.OK).body(
      new ResponseAPI("ok", "Get all categories successfully", categoryOutput)
    );
  }

  @GetMapping(value = "", params = "title")
  public ResponseEntity<ResponseAPI> findByTitle(@RequestParam String title) {
    return ResponseEntity.status(HttpStatus.OK).body(
      new ResponseAPI("ok", "Get categories by title successfully", iCategoryService.findByTitle(title))
    );
  }

  @PostMapping(value = "")
  public ResponseEntity<ResponseAPI> store(@RequestBody CategoryDTO categoryDTO) {
    return ResponseEntity.status(HttpStatus.OK).body(
      new ResponseAPI("ok", "Insert category successfully", iCategoryService.save(categoryDTO))
    );
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ResponseAPI> show(@PathVariable("id") long id) {
    if (iCategoryService.existsById(id)) {
      return ResponseEntity.status(HttpStatus.OK).body(
        new ResponseAPI("ok", "Category found", iCategoryService.findById(id))
      );
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
      new ResponseAPI("failed", "Category not found", "")
    );
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ResponseAPI> update(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") Long id) {
    if (iCategoryService.existsById(id)) {
      categoryDTO.setId(id);
      return ResponseEntity.status(HttpStatus.OK).body(
        new ResponseAPI("ok", "Update category successfully", iCategoryService.save(categoryDTO))
      );
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
      new ResponseAPI("failed", "Category not found", "")
    );
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<ResponseAPI> delete(@PathVariable("id") long id) {
    if (iCategoryService.existsById(id)) {
      iCategoryService.delete(id);
      return ResponseEntity.status(HttpStatus.OK).body(
        new ResponseAPI("ok", "Delete category successfully", "")
      );
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
      new ResponseAPI("failed", "Category not found", "")
    );
  }
}