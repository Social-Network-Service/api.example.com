package com.weibin.controller;

import com.weibin.entity.Video;
import com.weibin.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/video")
public class VideoController {
    
    @Resource
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<List<Video>> findAll() {
        List<Video> videos = videoService.findAll();
        return ResponseEntity.ok(videos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> findById(@PathVariable Integer id) {
        Video video = videoService.findById(id);
        if (video != null) {
            return ResponseEntity.ok(video);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Video> create(@RequestBody Video video) {
        int result = videoService.insert(video);
        if (result > 0) {
            return ResponseEntity.ok(video);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Video video) {
        video.setVideoId(id);
        int result = videoService.update(video);
        if (result > 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        int result = videoService.delete(id);
        if (result > 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
