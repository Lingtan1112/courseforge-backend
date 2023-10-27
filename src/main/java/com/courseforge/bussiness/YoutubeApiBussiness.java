package com.courseforge.bussiness;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.courseforge.dto.YoutubeResponseDTO;
import com.courseforge.interfaces.YoutubeFeignInterface;
import com.courseforge.model.YoutubeCache;
import com.courseforge.repo.YoutubeRepo;
import com.courseforge.util.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class YoutubeApiBussiness {
    
    @Autowired
    YoutubeFeignInterface youtubeFeignInterface;

    @Autowired
    YoutubeRepo youtubeRepo;

    @Value("${youtube.api-part}")
    private String part;

    @Value("${youtube.api-key}")
    private String apiKey;
    
    public YoutubeResponseDTO getVideoInfo(String videoId) throws IOException, ClassNotFoundException{

        JsonObject finalResponse = new JsonObject();
        
        List<YoutubeCache> existingRequestData = youtubeRepo.findByRequest(videoId);
        if(existingRequestData.size()>0){
            YoutubeCache youtubeCache = existingRequestData.get(0);
            byte[] byteResponse = youtubeCache.getResponse();
            Object tempJsonObject = (Object) CommonUtils.convertByteArrayToObject(byteResponse);
            String tempJsonObjectStr = new Gson().toJson(tempJsonObject);
            finalResponse = JsonParser.parseString(tempJsonObjectStr).getAsJsonObject();
        }else{
            Object responseJson = youtubeFeignInterface.getVideoInfo(videoId, part, apiKey);
            String responseString = new Gson().toJson(responseJson);
            finalResponse = JsonParser.parseString(responseString).getAsJsonObject();
            YoutubeCache youtubeCache = new YoutubeCache();
            youtubeCache.setRequest(videoId);
            youtubeCache.setResponse(CommonUtils.convertObjectToByteArray(responseJson));
            youtubeCache.setRequestType("VIDEOS");
            youtubeRepo.save(youtubeCache);
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        YoutubeResponseDTO youtubeResponseDTO = objectMapper.readValue(finalResponse.toString(), YoutubeResponseDTO.class);
        return youtubeResponseDTO;
    }


}