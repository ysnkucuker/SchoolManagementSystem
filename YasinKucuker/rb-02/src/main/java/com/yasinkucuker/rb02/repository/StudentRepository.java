package com.yasinkucuker.rb02.repository;

import com.yasinkucuker.rb02.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM studentable s WHERE s.id = ?1" , nativeQuery = true)
    Student findStudentById(long id);
}
