package com.example.thymleaf_crud2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.thymleaf_crud2.dto.Student;
import com.example.thymleaf_crud2.repository.StudentRepository;

@Repository
public class StudentDao {
	
	@Autowired
	StudentRepository studentRepository;
	
	public String insert(Student student) {
		studentRepository.save(student);
		return "Student added to database sucessfully";
	}
	
	public Object fetchByid(int id){
		Optional<Student> oe=studentRepository.findById(id);
		if(oe.isPresent()) {
			return oe.get();
		}
		else {
			return "The Student in this id is not present";
		}		
	}
	
	public Object fetchall(){
		List <Student> s=studentRepository.findAll();
		if(s.size()==0) {
			return "No student is prsent";
		}
		else {
			return s;
		}	
	}
	
	public String deltebyd(int id) {
		Optional<Student> oe=studentRepository.findById(id);
		if(oe.isPresent()) {
			studentRepository.deleteById(id);
			return "student deleted suceesfully";
		}
		else {
			return "Studnet is not present";
		}
	}
	
	
	public String deletell() {
		List <Student> s=studentRepository.findAll();
		if(s.size()==0) {
			return "No student is prsent";
		}
		else {
			studentRepository.deleteAll();
			return "data deleted successfully";
		}	
		
	}

}
