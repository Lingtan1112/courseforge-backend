package com.courseforge.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.courseforge.dto.YoutubeResponseDTO;
import com.courseforge.interfaces.YoutubeCacheInterface;
import com.courseforge.interfaces.YoutubeFeignInterface;
import com.courseforge.model.YoutubeCacheNoSQL;
import com.courseforge.repo.YoutubeRepoNoSQL;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
@Primary
public class YoutubeCacheNoSQLImpl implements YoutubeCacheInterface{

    @Autowired
    YoutubeFeignInterface youtubeFeignInterface;

    @Autowired
    YoutubeRepoNoSQL youtubeRepoNoSQL;

    @Value("${youtube.api-part}")
    private String part;

    @Value("${youtube.api-key}")
    private String apiKey;

    @Override
    public YoutubeResponseDTO getVideoInfo(String videoId) throws IOException, ClassNotFoundException {
        JsonObject finalResponse = new JsonObject();
        
        YoutubeCacheNoSQL existingRequestData = youtubeRepoNoSQL.findByRequest(videoId);
        if(existingRequestData != null){
            YoutubeCacheNoSQL youtubeCache = existingRequestData;
            String tempJsonObjectStr = youtubeCache.getResponse();
            finalResponse = JsonParser.parseString(tempJsonObjectStr).getAsJsonObject();
        }else{
            Object responseJson = youtubeFeignInterface.getVideoInfo(videoId, part, apiKey);
            String responseString = new Gson().toJson(responseJson);
            finalResponse = JsonParser.parseString(responseString).getAsJsonObject();
            YoutubeCacheNoSQL youtubeCache = new YoutubeCacheNoSQL();
            youtubeCache.setRequest(videoId);
            youtubeCache.setResponse(responseString);
            youtubeCache.setRequestType("VIDEOS");
            youtubeRepoNoSQL.save(youtubeCache);
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        YoutubeResponseDTO youtubeResponseDTO = objectMapper.readValue(finalResponse.toString(), YoutubeResponseDTO.class);
        return youtubeResponseDTO;
    }
    
}
