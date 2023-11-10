package com.courseforge.model;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="YOUTUBE_API_CACHE")
public class YoutubeCache {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="ID")
    private String id;

    @Column(name="REQUEST")
    private String request;

    @JsonIgnore
    @Column(name="RESPONSE")
    private byte[] response;

    @Column(name="REQUEST_TYPE")
    private String requestType;

    @Transient
    private String requestString;

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
    public String getRequestString() {
        return requestString;
    }
    public void setRequestString(String requestString) {
        this.requestString = requestString;
    }
   
    
}
