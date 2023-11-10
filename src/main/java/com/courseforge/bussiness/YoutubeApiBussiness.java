package com.courseforge.bussiness;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.courseforge.dto.YoutubeResponseDTO;
import com.courseforge.interfaces.YoutubeCacheInterface;
import com.courseforge.interfaces.YoutubeFeignInterface;

@Service
public class YoutubeApiBussiness {
    
    @Autowired
    YoutubeFeignInterface youtubeFeignInterface;

    @Autowired
    YoutubeCacheInterface youtubeCacheInterface;

    @Value("${youtube.api-part}")
    private String part;

    @Value("${youtube.api-key}")
    private String apiKey;
    
    public YoutubeResponseDTO getVideoInfo(String videoId) throws IOException, ClassNotFoundException{
        return youtubeCacheInterface.getVideoInfo(videoId);
    }


}