package com.courseforge.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.courseforge.bussiness.CourseBusiness;
import com.courseforge.model.Course;

import graphql.GraphQL;


@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    CourseBusiness courseBusiness;

    @Autowired
    private GraphQL graphQL;

    @PostMapping("/list")
    public ResponseEntity<Object> list(){
        // ExecutionResult courseList = graphQL.execute("fetchCourseList");
        List<Course> courseList = courseBusiness.fetchCourseList();
        return new ResponseEntity<>(courseList, HttpStatus.OK); 
    }

    // @PostMapping("/save")
    // public ResponseEntity<Course> saveCourse(@RequestParam(name="courseImage", required=false) MultipartFile file, @RequestParam("courseJson") String courseJson){
    //     Course savedCourse = new Course();
    //     try{
    //         savedCourse = courseBusiness.saveCourse(courseJson,file);
    //     }catch(Exception e){
    //         e.printStackTrace();
    //         System.out.println(e.getMessage());
    //     }
    //     return new ResponseEntity<Course>(savedCourse, HttpStatus.OK);
    // }

    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        Course savedCourse = new Course();
        try{
            savedCourse = courseBusiness.saveCourse(course);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            System.err.println(e);
        }
        return new ResponseEntity<Course>(savedCourse, HttpStatus.OK);
    }


    @GetMapping("/edit/{courseId}")
    public ResponseEntity<Course> fetchByCourseId(@PathVariable Long courseId){
        Course course = courseBusiness.fetchCourseById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/loaduploadedimage")
    public ResponseEntity<String> loadUploadedImage(@RequestParam(name="courseImage", required=false) MultipartFile file) throws IOException{
        byte[] imageBytes = file.getBytes();
        String data = Base64.getEncoder().encodeToString(imageBytes);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
