package com.courseforge.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courseforge.model.YoutubeCache;

@Repository
public interface YoutubeRepo  extends JpaRepository<YoutubeCache, Long>{
    
    public List<YoutubeCache> findByRequest(String videoId);

}
