package com.example.thymleaf_crud2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.thymleaf_crud2.dao.StudentDao;
import com.example.thymleaf_crud2.dto.Student;

@Controller
public class StudentController {
	@Autowired 
	StudentDao studentDao;

	@GetMapping("/")
    public String index() {
        return "redirect:/home";
    }
	
	@GetMapping("/home")
	public String home() {
		return "Studenthome.html";
	}
	
	@GetMapping("/studentinsert")
	public String sinsert() {
		return "Studentinsert.html";
	}
	
	@GetMapping("/fetchstu")
	public String fetchids() {
		return "Studentgeting.html";
	}
	
	@GetMapping("/deletestu")
	public String fetchall() {
		return "Studentdelete.html";
	}
	
	
	@PostMapping("/inserting")
	@ResponseBody
	public String insert(@ModelAttribute Student student) {
		return studentDao.insert(student);
	}
	
	
	
	@GetMapping("/fetchid")
	@ResponseBody
	public Object fetchByid(@RequestParam int id) {
		return studentDao.fetchByid(id);
	}
	
	@GetMapping("/fetchalls")
	@ResponseBody
	public Object fetchbyid() {
		return studentDao.fetchall();
	}
	
	@GetMapping("/deleteid")
	@ResponseBody
	public String deltebyd(@RequestParam int id) {
		return studentDao.deltebyd(id);
	}
	
	@GetMapping("/deletealls")
	@ResponseBody
	public String deletell() {
		return studentDao.deletell();
		
	}

	
	

}
