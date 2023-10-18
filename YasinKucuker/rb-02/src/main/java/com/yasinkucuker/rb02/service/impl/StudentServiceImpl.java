package com.yasinkucuker.rb02.service.impl;


import com.yasinkucuker.rb02.exception.StudentNotFoundException;
import com.yasinkucuker.rb02.models.Student;
import com.yasinkucuker.rb02.repository.CourseRepository;
import com.yasinkucuker.rb02.repository.StudentRepository;
import com.yasinkucuker.rb02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("StudentServiceImpl")

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findStudentById(long id){
        System.out.println("Student is being searched...");
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID : " + id));
    }

    @Override
    public void saveorUpdate(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }



}
