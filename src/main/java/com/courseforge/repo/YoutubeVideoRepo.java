package com.courseforge.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.courseforge.model.YoutubeVideo;

@Repository
public interface YoutubeVideoRepo extends JpaRepository<YoutubeVideo, Long>{

    List<YoutubeVideo> findByCourseCourseId(String uuid);

    void deleteById(Long videoId);

    @Query("SELECT course.courseId from YoutubeVideo y where y.videoId=:id")
    String findCourseIdById(Long id);

}
