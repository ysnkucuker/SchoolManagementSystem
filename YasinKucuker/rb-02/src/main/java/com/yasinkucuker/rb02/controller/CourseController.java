package com.yasinkucuker.rb02.controller;

import com.yasinkucuker.rb02.models.Course;
import com.yasinkucuker.rb02.models.Student;
import com.yasinkucuker.rb02.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Qualifier("CourseServiceImpl")
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses/{id}")
    public Course findCourseById(@PathVariable long id){
        return courseService.findCourseById(id);
    }

    @GetMapping("/courses")
    public List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }

    @PostMapping("/courses")
    public void saveCourse(Course course){
        courseService.saveorUpdate(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable long id){
        courseService.deleteCourse(id);
    }
}
