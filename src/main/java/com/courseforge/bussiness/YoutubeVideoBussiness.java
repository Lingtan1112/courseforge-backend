package com.courseforge.bussiness;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseforge.model.YoutubeVideo;
import com.courseforge.repo.YoutubeVideoRepo;

@Service
public class YoutubeVideoBussiness {

    @Autowired(required = false)
    YoutubeVideoRepo youtubeVideoRepo;
    
    public List<YoutubeVideo> save(YoutubeVideo youtubeVideo){
        if(youtubeVideo.getCreatedOn() == null){
            youtubeVideo.setCreatedOn(LocalDateTime.now());
        }
        youtubeVideo.setUpdatedOn(LocalDateTime.now());
        youtubeVideoRepo.save(youtubeVideo);
        return youtubeVideoRepo.findByCourseCourseId(youtubeVideo.getCourse().getCourseId());
    }

    public List<YoutubeVideo> fetchVideosByCourseId(String courseId) {
        return youtubeVideoRepo.findByCourseCourseId(courseId);
    }

    public List<YoutubeVideo> deleteVideo(Long videoId) {
        String courseId = youtubeVideoRepo.findCourseIdById(videoId);
        youtubeVideoRepo.deleteById(videoId);
        return youtubeVideoRepo.findByCourseCourseId(courseId);
    }

}
