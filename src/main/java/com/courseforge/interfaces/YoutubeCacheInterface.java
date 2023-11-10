package com.courseforge.interfaces;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.courseforge.dto.YoutubeResponseDTO;

@Component
public interface YoutubeCacheInterface {
    
    public YoutubeResponseDTO getVideoInfo(String videoId) throws IOException, ClassNotFoundException;

}
