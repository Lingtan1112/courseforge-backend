package com.courseforge.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.courseforge.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, String>{

    @Query("SELECT c FROM Course c WHERE id=:courseId ORDER BY c.courseId ASC")
    public Course fetchByCourseId(@Param("courseId") String courseId);

    @Query("SELECT c FROM Course c ORDER BY c.courseId ASC")
    public List<Course> fetchCourseByActiveStatus();

}
