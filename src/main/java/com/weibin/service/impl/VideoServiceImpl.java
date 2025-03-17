package com.weibin.service.impl;

import com.weibin.entity.Video;
import com.weibin.mapper.VideoMapper;
import com.weibin.service.VideoService;
import com.weibin.vo.PageResult;
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

    @Override
    public PageResult<Video> findByPage(int pageNum, int pageSize) {
        // 计算偏移量
        int offset = (pageNum - 1) * pageSize;
        // 查询分页数据
        List<Video> list = videoMapper.findByPage(offset, pageSize);
        // 查询总记录数
        int total = videoMapper.count();
        // 返回分页结果
        return new PageResult<>(list, total, pageNum, pageSize);
    }
}
