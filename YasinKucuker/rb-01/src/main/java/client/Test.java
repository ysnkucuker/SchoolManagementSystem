package client;

import jakarta.persistence.EntityManager;
import models.*;
import utils.EntityManagerUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[]args){
        System.out.println("Start....");


        Course course1 = new Course("Mathematics", 10014125, 100);
        Course course2 = new Course("Biology", 10014126, 80);
        Course course3 = new Course("English Language", 10014127, 75);

        Student student1 = new Student("Yasin", LocalDate.of(1991,8,5),"Karaman", Gender.male);
        Student student2 = new Student("Ahmet", LocalDate.of(2001,12,7),"Antalya", Gender.male);
        Student student3 = new Student("Zehra", LocalDate.of(1995,11,28),"İstanbul", Gender.female);

        Instructor permanentInstructor1 = new PermanentInstructor("Ali", "Karaman", "05451254", 28.56);
        Instructor visitedResearcher1 = new VisitedResearcher("Ayşe", "Konya","2131231", 100.23);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(student3);
        studentList2.add(student2);

        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);

        List<Course> courseList1 = new ArrayList<>();
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

        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(course1);
            entityManager.persist(course2);
            entityManager.persist(course3);
            entityManager.persist(student1);
            entityManager.persist(student2);
            entityManager.persist(student3);
            entityManager.persist(permanentInstructor1);
            entityManager.persist(visitedResearcher1);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

        System.out.println("Stop....");

    }
}
