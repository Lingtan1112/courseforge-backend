package com.courseforge.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.courseforge.model.YoutubeVideo;

@Repository
public interface YoutubeVideoRepo extends JpaRepository<YoutubeVideo, Long>{

    List<YoutubeVideo> findByCourseCourseId(Long courseId);

}
