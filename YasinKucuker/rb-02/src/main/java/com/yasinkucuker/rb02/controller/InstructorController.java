package com.yasinkucuker.rb02.controller;

import com.yasinkucuker.rb02.models.Instructor;
import com.yasinkucuker.rb02.models.Student;
import com.yasinkucuker.rb02.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {

    @Qualifier("InstructorServiceImpl")
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors/{id}")
    public Instructor findInstructorById(@PathVariable long id){
        return instructorService.findInstructorById(id);
    }

    @GetMapping("/instructors")
    public List<Instructor> findAllInstuctors() {
        return instructorService.findAllInstructors();
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(Instructor instructor){
        return instructorService.updateInstructor(instructor);
    }
    @PostMapping("/instructors")
    public void saveorUpdateInstructor(Instructor instructor){
        instructorService.saveorUpdate(instructor);
    }

    @DeleteMapping("/instructors/{id}")
    private void deleteInstructor(@PathVariable long id){
        instructorService.deleteInstructor(id);
    }
}
