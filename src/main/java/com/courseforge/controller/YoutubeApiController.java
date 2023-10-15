package com.courseforge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/youtube")
public class YoutubeApiController {
   
    @GetMapping("/fetch")
    public ResponseEntity<Object> getVideoInfo(){
        
        return new ResponseEntity<>("Demo",HttpStatus.OK);
    } 
    
}
