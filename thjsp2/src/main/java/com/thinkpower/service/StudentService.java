package com.thinkpower.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkpower.model.Student;
import com.thinkpower.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAll(){
		return studentRepository.findAll();
	}
	
	public Student getOne(Integer id) {
		return studentRepository.findById(id).get();
	}
	

}
