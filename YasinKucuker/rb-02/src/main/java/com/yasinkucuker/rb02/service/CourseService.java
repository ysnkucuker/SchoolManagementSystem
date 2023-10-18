package com.yasinkucuker.rb02.service;

import com.yasinkucuker.rb02.models.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();
    Course findCourseById(long id);

    void saveorUpdate(Course course);

    void deleteCourse(Long id);

    Course updateCourse(Course course);
}
