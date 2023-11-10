package com.courseforge.dto;

import java.time.LocalDateTime;

public class YoutubeVideoDTO {

    private String id;

    private String title;

    private byte[] description;

    private String videoId;

    private String videoUrl;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private String thumbnail;

    private int displayOrder;

    private CourseDTO course;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public byte[] getDescription() {
        return description;
    }
    public void setDescription(byte[] description) {
        this.description = description;
    }
    public String getVideoId() {
        return videoId;
    }
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
    public String getVideoUrl() {
        return videoUrl;
    }
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public int getDisplayOrder() {
        return displayOrder;
    }
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
  
    public CourseDTO getCourse() {
        return course;
    }
    public void setCourse(CourseDTO course) {
        this.course = course;
    }
    
}
