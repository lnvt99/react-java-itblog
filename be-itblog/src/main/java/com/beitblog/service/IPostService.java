package com.beitblog.service;

import com.beitblog.dto.PostDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPostService {
  int count();
  List<PostDTO> findAll();
  List<PostDTO> findAll(Pageable pageable);
  List<PostDTO> findByTitle(String title);
  PostDTO findById(long id);
  PostDTO save(PostDTO postDTO);
  void delete(long[] ids);
}
