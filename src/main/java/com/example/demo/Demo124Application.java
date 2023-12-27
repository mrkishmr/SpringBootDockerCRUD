package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import com.example.demo.controller.*;
import com.example.demo.modal.Student;

//1.@CompnentScan
//2.@EnableAutoConfiguration
//3.@SpringBootConfiguration
@SpringBootApplication
public class Demo124Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo124Application.class, args);
		
		FirstController obj=new FirstController();
		String str=obj.firstApi();
		System.out.println(str);
		
		
	}

}
