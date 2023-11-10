package com.courseforge.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.courseforge.dto.YoutubeResponseDTO;



@Component
@FeignClient(name="youtube-api", url="https://content-youtube.googleapis.com/youtube/v3/", configuration = YoutubeResponseDTO.class)
public interface YoutubeFeignInterface{

    // @GetMapping("/videos")
    // @Headers("application/json;charset=UTF-8")
    // YoutubeResponseDTO getVideoInfo(@RequestParam("id") String videoId,@RequestParam("part") String part,@RequestParam("key") String apiKey);
    
    @RequestMapping(method = RequestMethod.GET, value = "/videos", produces = "application/json")
    Object getVideoInfo(@RequestParam("id") String videoId,@RequestParam("part") String part,@RequestParam("key") String apiKey);
}
