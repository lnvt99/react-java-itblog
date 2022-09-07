package com.beitblog.api;

import com.beitblog.dto.PostDTO;

import java.util.ArrayList;
import java.util.List;

public class PostOutput {
  int currentPage;
  int totalPage;
  List<PostDTO> postDTOList = new ArrayList<>();

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

  public List<PostDTO> getPostDTOList() {
    return postDTOList;
  }

  public void setPostDTOList(List<PostDTO> postDTOList) {
    this.postDTOList = postDTOList;
  }
}
