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
import com.courseforge.dto.CourseDTO;
import com.courseforge.model.Course;

import graphql.GraphQL;


@RestController
@RequestMapping("/course")
@CrossOrigin(origins = {"http://localhost:3000", "https://subtle-ganache-18e965.netlify.app"})
public class CourseController {

    @Autowired
    CourseBusiness courseBusiness;

    @PostMapping("/list")
    public ResponseEntity<Object> list(){
        List<CourseDTO> courseList = courseBusiness.fetchCourseList();
        return new ResponseEntity<>(courseList, HttpStatus.OK); 
    }

    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody CourseDTO course){
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
    public ResponseEntity<Course> fetchByCourseId(@PathVariable String courseId){
        Course course = courseBusiness.fetchCourseById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/loaduploadedimage")
    public ResponseEntity<String> loadUploadedImage(@RequestParam(name="courseImage", required=false) MultipartFile file) throws IOException{
        byte[] imageBytes = file.getBytes();
        String data = Base64.getEncoder().encodeToString(imageBytes);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/delete/{courseId}")
    public ResponseEntity<List<CourseDTO>> deleteCourseById(@PathVariable String courseId){
        List<CourseDTO> courseDTO = courseBusiness.deleteCourseById(courseId);
        return new ResponseEntity<List<CourseDTO>>(courseDTO, HttpStatus.OK);
    }

}
