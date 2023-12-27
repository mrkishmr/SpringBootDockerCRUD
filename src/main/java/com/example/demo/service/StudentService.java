package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.modal.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> getAllStudent(){
		
      List<Student> allStudents=studentRepo.findAll();
		return allStudents;
	}
	
	
	public String addStudent(Student student) {
		Student student1=studentRepo.save(student);
		if(student1 != null) {
			return "student added successfully";
		}
		return "somthing went wrong";
	}
	
	
	public String removeStudent(int id) {
		studentRepo.deleteById(id);
		return "deleted successfully";
	}
	
	public Optional<Student> getStudentById(int id) {
		Optional<Student> student=studentRepo.findById(id);
		return student;
	}
	
	public String updateStudent(int id,String name) {
		
		Student student=studentRepo.getById(id);
		student.setId(id);
		student.setName(name);
		
	Student student1=studentRepo.save(student);
		
	if(student1 != null) {
		return "student updated successfully";
		}
		return "somthing went wrong";
		
	}
	
}
