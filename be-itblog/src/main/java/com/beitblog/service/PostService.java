package com.beitblog.service;

import com.beitblog.converter.PostConverter;
import com.beitblog.dto.PostDTO;
import com.beitblog.entity.PostEntity;
import com.beitblog.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService {
  @Autowired
  private IPostRepository iPostRepository;
  @Autowired
  private PostConverter postConverter;
  @Override
  public int count() {
    return (int) iPostRepository.count();
  }

  @Override
  public List<PostDTO> findAll() {
    List<PostDTO> postDTOList = new ArrayList<>();
    List<PostEntity> postEntityList = iPostRepository.findAll();
    for (PostEntity postEntity: postEntityList) {
      postDTOList.add(postConverter.toDTO(postEntity));
    }
    return postDTOList;
  }

  @Override
  public List<PostDTO> findAll(Pageable pageable) {
    List<PostDTO> postDTOList = new ArrayList<>();
    List<PostEntity> postEntityList = iPostRepository.findAll(pageable).getContent();
    for (PostEntity postEntity: postEntityList) {
      PostDTO postDTO = postConverter.toDTO(postEntity);
      postDTOList.add(postDTO);
    }
    return postDTOList;
  }

  @Override
  public List<PostDTO> findByTitle(String title) {
    List<PostDTO> postDTOList = new ArrayList<>();
    List<PostEntity> postEntityList = iPostRepository.findByTitleContaining(title);
    for (PostEntity postEntity: postEntityList) {
      PostDTO postDTO = postConverter.toDTO(postEntity);
      postDTOList.add(postDTO);
    }
    return postDTOList;
  }

  @Override
  public PostDTO findById(long id) {
    PostEntity postEntity = iPostRepository.findById(id);
    return postConverter.toDTO(postEntity);
  }

  @Override
  public PostDTO save(PostDTO postDTO) {
    PostEntity postEntity;
    if (postDTO.getId() != null) {
      PostEntity oldPostEntity = iPostRepository.findById(postDTO.getId()).get();
      postEntity = postConverter.toEntity(postDTO, oldPostEntity);
    } else {
      postEntity = postConverter.toEntity(postDTO);
    }
    postEntity = iPostRepository.save(postEntity);
    return postConverter.toDTO(postEntity);
  }

  @Override
  public void delete(long[] ids) {
    for (long id: ids) {
      iPostRepository.deleteById(id);
    }
  }
}
