package com.courseforge.model;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;

@Document(collection = "YoutubeCache")
public class YoutubeCacheNoSQL {

    @Id
    private String id;

    private String request;

    private String response;

    private String requestType;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getRequest() {
        return request;
    }
    public void setRequest(String request) {
        this.request = request;
    }
    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }
    public String getRequestType() {
        return requestType;
    }
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
   
    
}
