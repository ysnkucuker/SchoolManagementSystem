package com.yasinkucuker.rb02.service;

import com.yasinkucuker.rb02.models.Student;

import java.sql.Struct;
import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(long id);

    void SaveorUpdate(Student student);

    void DeleteStudent(Long id);

    Student UpdateStudent(Student student, Long id);
}
