package com.courseforge.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseforge.dto.CourseDTO;
import com.courseforge.impl.CourseImpl;
import com.courseforge.interfaces.CourseInterface;
import com.courseforge.model.Course;



@Service
public class CourseBusiness {
    
    @Autowired
    CourseInterface courseInterface;
    

    public List<CourseDTO> fetchCourseList(){
        return courseInterface.fetchCourseList();
    } 

    public Course saveCourse(CourseDTO course) {
        return courseInterface.saveCourse(course);
    }

    public Course fetchCourseById(String courseId){
        return courseInterface.fetchCourseById(courseId);
    }

    public List<CourseDTO> deleteCourseById(String courseId){
        return courseInterface.deleteCourse(courseId);
    }
    
}
