package com.courseforge.bussiness;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.courseforge.model.Course;
import com.courseforge.repo.CourseRepo;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class CourseBusiness {
    
    @Autowired
    CourseRepo courseRepo;

    public List<Course> fetchCourseList(){
        return courseRepo.fetchCourseByActiveStatus();
    } 

	

    // public Course saveCourse(String courseJson, MultipartFile file) {
    //     Course savedCourse = null;
    //     try{
    //         if(courseJson != null && !courseJson.isEmpty()){
    //             JsonObject object = JsonParser.parseString(courseJson).getAsJsonObject();
    //             Course course = new Course();
    //             course.setCourseTitle(object.get("courseTitle").getAsString());
    //             course.setCourseDescription(object.get("courseDescription").getAsString());
    //             if(object.get("courseId") != null && object.get("courseId").getAsLong() > 0){
    //                 course.setCourseId(object.get("courseId").getAsLong());
    //                 course.setCreatedOn(LocalDateTime.parse(object.get("createdOn").getAsString()));
    //             }else{
    //                 course.setCourseId(0L);
    //                 course.setCreatedOn(LocalDateTime.now());
    //             }
    //             course.setUpdatedOn(LocalDateTime.now());
    //             course.setIsCourseActive(object.get("isCourseActive").getAsString());
                
    //             if(file != null){
    //                 course.setCourseImage(file.getBytes());
    //             }else{
    //                  course.setCourseImage(object.get("courseImage").toString().getBytes());
    //             }

    //             savedCourse = courseRepo.save(course);
    //         }
            
    //     }catch(Exception e){
    //         e.printStackTrace();
    //         System.err.println(e.getMessage());
    //     }

    //     return savedCourse;
    // }

    public Course saveCourse(Course course) {
        Course savedCourse = null;
        try{
            if(course != null){
                if(course.getCreatedOn() == null){
                    course.setCreatedOn(LocalDateTime.now());
                }
                course.setUpdatedOn(LocalDateTime.now());

                course.getVideoList().forEach(i->i.setCourse(course));

                savedCourse = courseRepo.save(course);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return savedCourse;
    }

    public Course fetchCourseById(Long courseId){
        return courseRepo.fetchByCourseId(courseId);
    }
    
}
