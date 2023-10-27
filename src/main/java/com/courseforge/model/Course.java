package com.courseforge.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {
        
    public Course(Long courseId, String courseTitle, String courseDescription,String courseImage, LocalDateTime createdOn,
        LocalDateTime updatedOn) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.courseImage = courseImage;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Course() {
       
    }
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COURSE_ID")
    private Long courseId;

    @Column(name = "TITLE")
    private String courseTitle;

    @Column(name = "DESCRIPTION")
    private String courseDescription;
    
    @Column(name = "THUMBNAIL")
    private String courseImage;
    
    @Column(name="CREATED_ON")
    private LocalDateTime createdOn;

    @Column(name="UPDATED_ON")
    private LocalDateTime updatedOn;

    @Column(name="STATUS")
    private String isCourseActive;

    @OneToMany(mappedBy="course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<YoutubeVideo> videoList;
    
    public List<YoutubeVideo> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<YoutubeVideo> videoList) {
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

    public Long getCourseId() {
        return courseId;
    }
    public void setCourseId(Long courseId) {
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
