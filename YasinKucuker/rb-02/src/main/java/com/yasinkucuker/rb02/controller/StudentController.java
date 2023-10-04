package com.yasinkucuker.rb02.controller;

import com.yasinkucuker.rb02.models.Student;
import com.yasinkucuker.rb02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Qualifier("StudentServiceImpl")
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable  long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }
}
