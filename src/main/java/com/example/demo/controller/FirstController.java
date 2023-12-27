package com.example.demo.controller;


import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Student;
import com.example.demo.service.StudentService;
//@Controller --->It takes only request. It will not take request body and response body

@RestController //It does three jobs of (@Controller, @RequestBody, @ResponseBody)
public class FirstController {
	
	//StudentService obj=new StudentService();
	
	@Autowired
	private StudentService studentService;
	
 //use Rest Api's
	
	//@RequestMapping("/first") //web service
	@GetMapping("/first")  //  Rest Api
	public String firstApi() {
		
	  String str="This is my first api in spring boot";
	  return str;
	}

	@RequestMapping("/allstudents")
	public List<Student> getAllStudents(){
		
		List<Student> students=studentService.getAllStudent();
		
		
		return students;
		
	}
	
	@RequestMapping("/addStudent")
	public String addingStudent(@RequestBody Student student) {
		String result=studentService.addStudent(student);
		
		return result;
		
	}
	
	@RequestMapping("/deleteStudent/{id}")
	public String deletingStudentById(@PathVariable int id) {
		String result=studentService.removeStudent(id);
		return result;
	}
	
	@RequestMapping("/findStudentById/{id}")
	public Optional<Student> getStudentById(@PathVariable int id) {
		Optional<Student> student=studentService.getStudentById(id);
		
		return student;
	}
	
	@RequestMapping("/updateStudentById/{id}/{name}")
	public String updateStudentName(@PathVariable int id,@RequestParam("name") String name) {
		String result=studentService.updateStudent(id,name);
		System.out.println(name);
		return result;
	}
}
