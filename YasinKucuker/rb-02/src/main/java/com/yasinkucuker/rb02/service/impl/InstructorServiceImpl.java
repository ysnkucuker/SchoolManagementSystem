package com.yasinkucuker.rb02.service.impl;

import com.yasinkucuker.rb02.exception.InstructorNotFoundException;
import com.yasinkucuker.rb02.models.Instructor;
import com.yasinkucuker.rb02.repository.InstructorRepository;
import com.yasinkucuker.rb02.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InstructorServiceImpl")
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor findInstructorById(long id){
        return instructorRepository.findById(id)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id : " + id));
    }

    public List<Instructor> findAllInstructors(){
        return instructorRepository.findAll();
    }
}