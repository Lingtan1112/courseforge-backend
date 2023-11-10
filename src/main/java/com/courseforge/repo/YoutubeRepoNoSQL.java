package com.courseforge.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courseforge.model.YoutubeCacheNoSQL;

@Repository
public interface YoutubeRepoNoSQL  extends MongoRepository<YoutubeCacheNoSQL, String>{

    public YoutubeCacheNoSQL findByRequest(String videoId);

}
