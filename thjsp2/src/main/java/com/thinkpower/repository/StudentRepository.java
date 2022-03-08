package com.thinkpower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkpower.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
