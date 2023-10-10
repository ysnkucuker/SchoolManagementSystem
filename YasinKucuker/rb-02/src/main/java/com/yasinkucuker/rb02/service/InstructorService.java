package com.yasinkucuker.rb02.service;

import com.yasinkucuker.rb02.models.Instructor;


import java.util.List;

public interface InstructorService {
    List<Instructor> findAllInstructors();
    Instructor findInstructorById(long id);
    void SaveorUpdate(Instructor instructor);

    void DeleteInstructor(Long id);

    Instructor UpdateInstructor(Instructor instructor);
}
