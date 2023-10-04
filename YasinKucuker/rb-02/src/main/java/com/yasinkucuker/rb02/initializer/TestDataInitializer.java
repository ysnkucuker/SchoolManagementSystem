package com.yasinkucuker.rb02.initializer;

import com.yasinkucuker.rb02.models.*;
import com.yasinkucuker.rb02.repository.CourseRepository;
import com.yasinkucuker.rb02.repository.InstructorRepository;
import com.yasinkucuker.rb02.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional
public class TestDataInitializer implements ApplicationRunner {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;

    public TestDataInitializer(CourseRepository courseRepository, InstructorRepository instructorRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Started...");

        Course course1 = new Course("Mathematics", 10014125, 100);
        Course course2 = new Course("Biology", 10014126, 80);
        Course course3 = new Course("English Language", 10014127, 75);

        Student student1 = new Student("Yasin", LocalDate.of(1991,8,5),"Karaman", Gender.male);
        Student student2 = new Student("Ahmet", LocalDate.of(2001,12,7),"Antalya", Gender.male);
        Student student3 = new Student("Zehra", LocalDate.of(1995,11,28),"İstanbul", Gender.female);

        Instructor permanentInstructor1 = new PermanentInstructor("Ali", "Karaman", "05451254", 28.56);
        Instructor visitedResearcher1 = new VisitedResearcher("Ayşe", "Konya","2131231", 100.23);

        Set<Student> studentList = new HashSet<>();
        studentList.add(student1);
        studentList.add(student2);

        Set<Student> studentList2 = new HashSet<>();
        studentList2.add(student3);
        studentList2.add(student2);

        Set<Course> courseList = new HashSet<>();
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);

        Set<Course> courseList1 = new HashSet<>();
        courseList1.add(course3);
        courseList1.add(course1);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(visitedResearcher1);
        course3.setInstructor(visitedResearcher1);

        course1.setStudentList(studentList);
        course2.setStudentList(studentList2);
        course3.setStudentList(studentList);

        student1.setCourseList(courseList1);
        student2.setCourseList(courseList);
        student3.setCourseList(courseList1);

        permanentInstructor1.setCourseList(courseList);
        visitedResearcher1.setCourseList(courseList1);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        instructorRepository.save(visitedResearcher1);
        instructorRepository.save(permanentInstructor1);

        System.out.println("Stopped...");
    }
}

