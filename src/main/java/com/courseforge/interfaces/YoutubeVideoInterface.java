package com.courseforge.interfaces;

import java.util.List;

import com.courseforge.model.YoutubeVideo;

public interface YoutubeVideoInterface {
    
     public List<YoutubeVideo> save(YoutubeVideo youtubeVideo);

    public List<YoutubeVideo> fetchVideosByCourseId(String courseId);

    public List<YoutubeVideo> deleteVideo(Long videoId);
}
