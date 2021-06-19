package com.fsmob.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsmob.Repository.StudentRepository;
import com.fsmob.model.student;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	@Autowired
	StudentRepository g1;
	@GetMapping
	@RequestMapping("demo1")
	public Long countGrade() {
		return (long) g1.findAll().size();
	}
	
	@PostMapping
	@RequestMapping("create")
	public student create(@RequestParam long id, 
			@RequestParam String fname, 
			@RequestParam String lname,
			@RequestParam long year,
			@RequestParam String contact,
			@RequestParam long age,
			@RequestParam Date dob,
			@RequestParam long gendar,
			@RequestParam String stcourse) {
		student g = new student();
		g.setStudid(id);
		g.setStfname(fname);
		g.setStlname(lname);
		g.setStcourse(stcourse);
		g.setStyear(year);
		g.setStcontact(contact);
		g.setStage(age);
		g.setDob(dob);
		g.setStgendar(gendar);
		return g1.saveAndFlush(g);
	}
}
