package com.courseforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.courseforge.bussiness.YoutubeVideoBussiness;
import com.courseforge.model.YoutubeVideo;

@RestController
@RequestMapping("/ytvideo")
@CrossOrigin(origins = "http://localhost:3000")
public class YoutubeVideoController {

    @Autowired
    YoutubeVideoBussiness youtubeVideoBussiness;
    
    @PostMapping("/save")
    public ResponseEntity<List<YoutubeVideo>> save(@RequestBody YoutubeVideo youtubeVideo){
        List<YoutubeVideo> youtubeVideoInfo = youtubeVideoBussiness.save(youtubeVideo);
        return new ResponseEntity<>(youtubeVideoInfo, HttpStatus.OK);
    }

    @PostMapping("/fetchall")
    public ResponseEntity<List<YoutubeVideo>> fetchAllVideos(@RequestParam("courseId") String courseId){
        List<YoutubeVideo> youtubeVideoList = youtubeVideoBussiness.fetchVideosByCourseId(courseId);
        return new ResponseEntity<>(youtubeVideoList, HttpStatus.OK);
    }

    @PostMapping("/delete/{videoId}")
    public ResponseEntity<List<YoutubeVideo>> deleteVideo(@PathVariable Long videoId){
        return new ResponseEntity<>(youtubeVideoBussiness.deleteVideo(videoId), HttpStatus.OK);
    }
}
