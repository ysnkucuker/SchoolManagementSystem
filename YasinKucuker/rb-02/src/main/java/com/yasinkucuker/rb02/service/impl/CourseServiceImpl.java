package com.yasinkucuker.rb02.service.impl;


import com.yasinkucuker.rb02.exception.CourseNotFoundException;
import com.yasinkucuker.rb02.repository.CourseRepository;
import com.yasinkucuker.rb02.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yasinkucuker.rb02.models.Course;
import com.yasinkucuker.rb02.service.CourseService;

import java.util.List;

@Service("CourseServiceImpl")
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course findCourseById(long id){
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID : " + id));
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

}