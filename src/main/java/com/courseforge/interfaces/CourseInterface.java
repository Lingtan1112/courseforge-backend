package com.courseforge.interfaces;

import java.util.List;

import com.courseforge.dto.CourseDTO;
import com.courseforge.model.Course;

public interface CourseInterface {
    
     public List<CourseDTO> fetchCourseList();

    public Course saveCourse(CourseDTO course);

    public Course fetchCourseById(String courseId);

    public List<CourseDTO> deleteCourse(String courseId);
    
}
