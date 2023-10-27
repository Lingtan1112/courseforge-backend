package com.courseforge.bussiness;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseforge.model.YoutubeVideo;
import com.courseforge.repo.YoutubeVideoRepo;

@Service
public class YoutubeVideoBussiness {

    @Autowired
    YoutubeVideoRepo youtubeVideoRepo;
    
    public List<YoutubeVideo> save(YoutubeVideo youtubeVideo){
        if(youtubeVideo.getCreatedOn() == null){
            youtubeVideo.setCreatedOn(LocalDateTime.now());
        }
        youtubeVideo.setUpdatedOn(LocalDateTime.now());
        youtubeVideoRepo.save(youtubeVideo);
        return youtubeVideoRepo.findByCourseCourseId(youtubeVideo.getCourse().getCourseId());
    }

    public List<YoutubeVideo> fetchVideosByCourseId(Long courseId) {
        return youtubeVideoRepo.findByCourseCourseId(courseId);
    }

}
