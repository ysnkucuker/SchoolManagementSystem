package com.yasinkucuker.rb02.service;

import com.yasinkucuker.rb02.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(long id);
}
