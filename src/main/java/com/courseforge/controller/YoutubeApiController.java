package com.courseforge.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.courseforge.bussiness.YoutubeApiBussiness;
import com.courseforge.dto.YoutubeResponseDTO;
import com.courseforge.model.YoutubeCache;
import com.courseforge.repo.YoutubeRepo;
import com.courseforge.util.CommonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

    @Autowired
    YoutubeRepo youtubeRepo;

    // @PostMapping("/fetch")
    // public ResponseEntity<Object> fetch(@RequestParam("videoId") String videoId) throws IOException, ClassNotFoundException, GeneralSecurityException{
    //     YoutubeResponseDTO data = youtubeApiBussiness.getVideoInfo(videoId);
    //     return new ResponseEntity<>(data,HttpStatus.OK);
    // }

    @PostMapping("/fetchById")
    public ResponseEntity<Object> fetchById(@RequestBody String query) throws IOException, ClassNotFoundException, GeneralSecurityException{
        ExecutionResult data = graphql.execute(query);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<Object> fetchAll() throws IOException, ClassNotFoundException, GeneralSecurityException{
       
        List<HashMap<String, Object>> data = youtubeRepo.findAll().stream().map(i -> { 
             HashMap<String, Object> data1 = new HashMap<>();
             data1.put("id", i.getId());
             data1.put("request", i.getRequest());
             data1.put("requestType", "VIDEOS");
             try {
                data1.put("response", new ObjectMapper().readValue(i.getRequestString(), YoutubeResponseDTO.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
             return data1;
        })
       .collect(Collectors.toList());


    //    List<YoutubeResponseDTO> youtubeResponseDTO = demo.stream().map(i-> {
    //     try {
    //         return new ObjectMapper().readValue(i.getRequestString(), YoutubeResponseDTO.class);
    //     } catch (JsonMappingException e) {
    //         e.printStackTrace();
    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }).collect(Collectors.toList());

       return new ResponseEntity<>(data,HttpStatus.OK);
    }

    private YoutubeCache convertByteToString(YoutubeCache youtubeCache){
        String tempJsonObjectStr;
        try {
            tempJsonObjectStr = new Gson().toJson(CommonUtils.convertByteArrayToObject(youtubeCache.getResponse()));
            youtubeCache.setRequestString(tempJsonObjectStr); 
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        
        return youtubeCache;
    }

   
    
}
