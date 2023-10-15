package com.courseforge.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseforge.model.Course;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
    
    @GetMapping("/list")
    public ResponseEntity<Course> fetch(){

        List<Course> courseList = new ArrayList<>();

        courseList.add(new Course(1,"Web Development Basics", "Learn the fundamentals of web development and important concepts of web dev","defaultCourseImage.jpg"));
        courseList.add(new Course(2,"JavaScript Mastery", "Master JavaScript programming for web development.","defaultCourseImage.jpg"));
        courseList.add(new Course(3,"Python for Data Science", "Explore data science using Python programming.","defaultCourseImage.jpg"));
        
        Map<String, List<Course>> courseMap = new HashMap<>();
        courseMap.put("courseList",courseList);
        
        return new ResponseEntity(courseMap, HttpStatus.OK);

    }
}
