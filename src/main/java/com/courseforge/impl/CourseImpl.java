package com.courseforge.impl;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.courseforge.dto.CourseDTO;
import com.courseforge.interfaces.CourseInterface;
import com.courseforge.model.Course;
import com.courseforge.repo.CourseRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class CourseImpl implements CourseInterface {

    @Autowired
    CourseRepo courseRepo;

    @Override
    public List<CourseDTO> fetchCourseList() {
        ObjectMapper customObjectMapper = new ObjectMapper();
        customObjectMapper.registerModule(new JavaTimeModule());
        List<Course> courseList = courseRepo.fetchCourseByActiveStatus();
        List<CourseDTO> courseDTOList = courseList.stream().map(i -> (customObjectMapper.convertValue(i, CourseDTO.class))).toList();
        return courseDTOList;
    }

    @Override
    public Course saveCourse(CourseDTO courseDTO) {
        Course savedCourse = null;

        ObjectMapper customObjectMapper = new ObjectMapper();
        customObjectMapper.registerModule(new JavaTimeModule());
        
        try {
            if (courseDTO != null) {
                if (courseDTO.getCreatedOn() == null) {
                    courseDTO.setCreatedOn(LocalDateTime.now());
                }
                courseDTO.setUpdatedOn(LocalDateTime.now());

                if (courseDTO.getVideoList() != null && courseDTO.getVideoList().size() > 0) {
                    courseDTO.getVideoList().forEach(i -> i.setCourse(courseDTO));
                }

                Course course = customObjectMapper.convertValue(courseDTO, Course.class);
                savedCourse = courseRepo.save(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return savedCourse;
    }

    @Override
    public Course fetchCourseById(String courseId) {
        return courseRepo.fetchByCourseId(courseId);
    }

    @Override
    public List<CourseDTO> deleteCourse(String courseId) {
        courseRepo.deleteById(courseId);
        ObjectMapper customObjectMapper = new ObjectMapper();
        customObjectMapper.registerModule(new JavaTimeModule());
        List<Course> courseList = courseRepo.fetchCourseByActiveStatus();
        List<CourseDTO> courseDTOList = courseList.stream().map(i -> (customObjectMapper.convertValue(i, CourseDTO.class))).toList();
        return courseDTOList;
    }

}
