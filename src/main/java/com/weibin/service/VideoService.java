package com.weibin.service;

import com.weibin.entity.Video;
import com.weibin.vo.PageResult;
import java.util.List;

public interface VideoService {
    List<Video> findAll();
    Video findById(Integer id);
    int insert(Video video);
    int update(Video video);
    int delete(Integer id);
    PageResult<Video> findByPage(int pageNum, int pageSize);
}
