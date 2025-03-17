package com.weibin.controller;

import com.weibin.entity.Video;
import com.weibin.service.VideoService;
import com.weibin.vo.PageResult;
import com.weibin.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/video")
//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8081"}, allowCredentials = "true")
@CrossOrigin(origins = "*")
public class VideoController {

    @Resource
    private VideoService videoService;

    @GetMapping("/list")
    public Result<PageResult<Video>> findByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        if (pageNum < 1) pageNum = 1;
        if (pageSize < 1) pageSize = 10;
        PageResult<Video> result = videoService.findByPage(pageNum, pageSize);
        return Result.success(result);
    }

    @GetMapping("/all")
    public Result<List<Video>> findAll() {
        List<Video> videos = videoService.findAll();
        return Result.success(videos);
    }

    @GetMapping("/{id}")
    public Result<Video> findById(@PathVariable Integer id) {
        Video video = videoService.findById(id);
        if (video != null) {
            return Result.success(video);
        }
        return Result.error(404, "视频不存在");
    }

    @PostMapping
    public Result<Video> create(@RequestBody Video video) {
        int result = videoService.insert(video);
        if (result > 0) {
            return Result.success(video, "创建成功");
        }
        return Result.error("创建失败");
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Integer id, @RequestBody Video video) {
        video.setVideoId(id);
        int result = videoService.update(video);
        if (result > 0) {
            return Result.success(null, "更新成功");
        }
        return Result.error(404, "视频不存在");
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        int result = videoService.delete(id);
        if (result > 0) {
            return Result.success(null, "删除成功");
        }
        return Result.error(404, "视频不存在");
    }
}
