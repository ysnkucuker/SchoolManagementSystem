package com.yasinkucuker.rb02.service;

import com.yasinkucuker.rb02.models.Course;
import com.yasinkucuker.rb02.models.Student;

import java.sql.Struct;
import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(long id);

    void saveorUpdate(Student student);


    void deleteStudent(Long id);

    Student updateStudent(Student student);
}
