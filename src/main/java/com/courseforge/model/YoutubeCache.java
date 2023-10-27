package com.courseforge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="YOUTUBE_API_CACHE")
public class YoutubeCache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="REQUEST")
    private String request;

    @Column(name="RESPONSE")
    private byte[] response;

    @Column(name="REQUEST_TYPE")
    private String requestType;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRequest() {
        return request;
    }
    public void setRequest(String request) {
        this.request = request;
    }
    public byte[] getResponse() {
        return response;
    }
    public void setResponse(byte[] response) {
        this.response = response;
    }
    public String getRequestType() {
        return requestType;
    }
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
   
    
}
