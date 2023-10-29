package com.courseforge.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.courseforge.dto.CourseDTO;
import com.courseforge.interfaces.CourseInterface;
import com.courseforge.model.Course;
import com.courseforge.model.CourseNoSQL;
import com.courseforge.repo.CourseNoSQLRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
@Primary
public class CourseNoSQLImpl implements CourseInterface{

    @Autowired
    CourseNoSQLRepo courseNoSQLRepo;

    private ObjectMapper customObjectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public List<CourseDTO> fetchCourseList() {
        List<CourseNoSQL> courseList = courseNoSQLRepo.findAll();
        List<CourseDTO> courseDTOList = courseList.stream().map(i -> (customObjectMapper.convertValue(i, CourseDTO.class))).toList();
        return courseDTOList;
    }
 
    @Override
    public Course saveCourse(CourseDTO couseDto) {
        CourseNoSQL courseNoSQL = customObjectMapper.convertValue(couseDto, CourseNoSQL.class);
        CourseNoSQL courseNoSQLResponse = courseNoSQLRepo.insert(courseNoSQL);
        return customObjectMapper.convertValue(courseNoSQLResponse, Course.class);
    }

    @Override
    public Course fetchCourseById(String courseId) {
        Course course = new Course();
        CourseNoSQL courseList = courseNoSQLRepo.findByCourseId(courseId);
        if(courseList != null){
            course = customObjectMapper.convertValue(courseList, Course.class);
        }
        return course;
    }


    public List<CourseDTO> deleteCourse(String courseId){
        courseNoSQLRepo.deleteById(courseId);
        List<CourseNoSQL> courseList = courseNoSQLRepo.findAll();
        List<CourseDTO> courseDTOList = courseList.stream().map(i -> (customObjectMapper.convertValue(i, CourseDTO.class))).toList();
        return courseDTOList;
    }
        
    
}
