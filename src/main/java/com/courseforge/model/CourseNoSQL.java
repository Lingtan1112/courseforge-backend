package com.courseforge.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Course")
public class CourseNoSQL {

    @Id
    private String courseId;

    @Field(name="courseTitle")
    private String courseTitle;

    private String courseDescription;
    
    private String courseImage;
    
    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private String isCourseActive;

    private List<YoutubeVideoNoSQL> videoList;
    
    public List<YoutubeVideoNoSQL> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<YoutubeVideoNoSQL> videoList) {
        this.videoList = videoList;
    }

    public String getIsCourseActive() {
        return isCourseActive;
    }

    public void setIsCourseActive(String isCourseActive) {
        this.isCourseActive = isCourseActive;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    public String getCourseDescription() {
        return courseDescription;
    }
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
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
    
}
