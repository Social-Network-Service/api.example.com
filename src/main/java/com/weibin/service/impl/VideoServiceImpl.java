package com.weibin.service.impl;

import com.weibin.entity.Video;
import com.weibin.mapper.VideoMapper;
import com.weibin.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    
    @Resource
    private VideoMapper videoMapper;

    @Override
    public List<Video> findAll() {
        return videoMapper.findAll();
    }

    @Override
    public Video findById(Integer id) {
        return videoMapper.findById(id);
    }

    @Override
    public int insert(Video video) {
        return videoMapper.insert(video);
    }

    @Override
    public int update(Video video) {
        return videoMapper.update(video);
    }

    @Override
    public int delete(Integer id) {
        return videoMapper.delete(id);
    }
}
