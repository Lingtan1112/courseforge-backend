package com.courseforge.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.courseforge.bussiness.YoutubeApiBussiness;
import com.courseforge.dto.YoutubeResponseDTO;

import graphql.ExecutionResult;
import graphql.GraphQL;


@RestController
@RequestMapping("/youtube")
@CrossOrigin(origins = "http://localhost:3000")
public class YoutubeApiController {

    @Autowired
    YoutubeApiBussiness youtubeApiBussiness;

    @Value("${youtube.api-key}")
    private String apiKey;

    @Autowired
    private GraphQL graphql;



    @PostMapping("/fetch")
    public ResponseEntity<Object> fetch(@RequestParam("videoId") String videoId) throws IOException, ClassNotFoundException, GeneralSecurityException{
        YoutubeResponseDTO data = youtubeApiBussiness.getVideoInfo(videoId);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @PostMapping("/fetchById")
    public ResponseEntity<Object> fetchById(@RequestBody String query) throws IOException, ClassNotFoundException, GeneralSecurityException{
        ExecutionResult data = graphql.execute(query);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    
}
