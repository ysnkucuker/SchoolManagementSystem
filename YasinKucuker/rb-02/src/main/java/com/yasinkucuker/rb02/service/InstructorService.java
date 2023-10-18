package com.yasinkucuker.rb02.service;

import com.yasinkucuker.rb02.models.Instructor;


import java.util.List;

public interface InstructorService {
    List<Instructor> findAllInstructors();
    Instructor findInstructorById(long id);
    void saveorUpdate(Instructor instructor);

    void deleteInstructor(Long id);

    Instructor updateInstructor(Instructor instructor);
}
