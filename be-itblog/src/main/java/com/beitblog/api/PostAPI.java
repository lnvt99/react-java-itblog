package com.beitblog.api;

import com.beitblog.dto.PostDTO;
import com.beitblog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PostAPI {
  @Autowired
  private IPostService iPostService;

  @GetMapping(value = "/posts")
  public PostOutput get(
    @RequestParam(value = "page", required = false) Integer page,
    @RequestParam(value = "limit", required = false) Integer limit
  ) {
    PostOutput postOutput = new PostOutput();
    if (page != null && limit != null) {
      postOutput.setCurrentPage(page);
      Pageable pageable = PageRequest.of(page - 1, limit);
      postOutput.setPostDTOList(iPostService.findAll(pageable));
      postOutput.setTotalPage((int) Math.ceil((double) (iPostService.count()) / limit));
    } else {
      postOutput.setPostDTOList(iPostService.findAll());
    }
    return postOutput;
  }

  @GetMapping(value = "/post", params = "title")
  public List<PostDTO> findByTitle(@RequestParam String title) {
    return iPostService.findByTitle(title);
  }

  @PostMapping(value = "/post")
  public PostDTO store(PostDTO postDTO) {
    return iPostService.save(postDTO);
  }

  @GetMapping(value = "/post/{id}")
  public PostDTO show(@PathVariable("id") long id) {
    return iPostService.findById(id);
  }

  @PutMapping(value = "/post/{id}")
  public PostDTO update(PostDTO postDTO, @PathVariable("id") long id) {
    postDTO.setId(id);
    return iPostService.save(postDTO);
  }

  @DeleteMapping(value = "/post")
  public void delete(long[] ids) {
    iPostService.delete(ids);
  }
}
