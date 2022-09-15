package com.beitblog.api;

import com.beitblog.dto.PostDTO;
import com.beitblog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/post")
public class PostAPI {
  @Autowired
  private IPostService iPostService;

  @GetMapping(value = "")
  public ResponseEntity<ResponseAPI> get(
    @RequestParam(value = "page", required = false) Integer page,
    @RequestParam(value = "limit", required = false) Integer limit
  ) {
    PostOutput postOutput = new PostOutput();

    page = page != null ? page : 1;
    limit = limit != null ? limit : 10;

    postOutput.setCurrentPage(page);
    Pageable pageable = PageRequest.of(page - 1, limit);
    postOutput.setPostDTOList(iPostService.findAll(pageable));
    postOutput.setTotalPage((int) Math.ceil((double) (iPostService.count()) / limit));
    return ResponseEntity.status(HttpStatus.OK).body(
      new ResponseAPI("ok", "Get all posts successfully", postOutput)
    );
  }

  @GetMapping(value = "", params = "title")
  public ResponseEntity<ResponseAPI> findByTitle(@RequestParam String title) {
    return ResponseEntity.status(HttpStatus.OK).body(
      new ResponseAPI("ok", "Get posts by title successfully", iPostService.findByTitle(title))
    );
  }

  @PostMapping(value = "")
  public ResponseEntity<ResponseAPI> store(@RequestBody PostDTO postDTO) {
    return ResponseEntity.status(HttpStatus.OK).body(
      new ResponseAPI("ok", "Insert post successfully", iPostService.save(postDTO))
    );
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ResponseAPI> show(@PathVariable("id") long id) {
    if (iPostService.existsById(id)) {
      return ResponseEntity.status(HttpStatus.OK).body(
        new ResponseAPI("ok", "Post found", iPostService.findById(id))
      );
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
      new ResponseAPI("failed", "Post not found", "")
    );
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ResponseAPI> update(@RequestBody PostDTO postDTO, @PathVariable("id") long id) {
    if (iPostService.existsById(id)) {
      postDTO.setId(id);
      return ResponseEntity.status(HttpStatus.OK).body(
        new ResponseAPI("ok", "Update post successfully", iPostService.save(postDTO))
      );
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
      new ResponseAPI("failed", "Post not found", "")
    );
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<ResponseAPI> delete(@PathVariable("id") long id) {
    if (iPostService.existsById(id)) {
      iPostService.delete(id);
      return ResponseEntity.status(HttpStatus.OK).body(
        new ResponseAPI("ok", "Delete post successfully", "")
      );
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
      new ResponseAPI("failed", "Post not found", "")
    );
  }
}
