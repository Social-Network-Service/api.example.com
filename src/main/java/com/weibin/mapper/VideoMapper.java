package com.weibin.mapper;

import com.weibin.entity.Video;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VideoMapper {
    List<Video> findAll();
    Video findById(Integer id);
    int insert(Video video);
    int update(Video video);
    int delete(Integer id);
}
