package com.codejava.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.codejava.model.Student;

@Service
public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByLastName(String lastname);
    
}
