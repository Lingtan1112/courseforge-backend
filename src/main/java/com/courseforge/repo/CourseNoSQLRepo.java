package com.courseforge.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.courseforge.model.CourseNoSQL;

public interface CourseNoSQLRepo extends MongoRepository<CourseNoSQL, String> {
    CourseNoSQL findByCourseId(String courseId);
} 
