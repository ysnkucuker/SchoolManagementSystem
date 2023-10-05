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

    @PostMapping("/instructors")
    public void SaveInstructor(Instructor instructor){
        instructorService.SaveorUpdate(instructor);
    }

    @DeleteMapping("/instructors/{id}")
    private void DeleteInstructor(@PathVariable long id){
        instructorService.DeleteInstructor(id);
    }
}
