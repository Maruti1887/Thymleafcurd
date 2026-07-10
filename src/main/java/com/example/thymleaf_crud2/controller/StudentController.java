package com.example.thymleaf_crud2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.thymleaf_crud2.dao.StudentDao;
import com.example.thymleaf_crud2.dto.Student;

@Controller
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    // Redirect root URL to home page
    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    // Home Page
    @GetMapping("/home")
    public String home() {
        return "Studenthome";
    }

    // Student Insert Page
    @GetMapping("/studentinsert")
    public String studentInsert() {
        return "Studentinsert";
    }

    // Fetch Student Page
    @GetMapping("/fetchstu")
    public String fetchStudent() {
        return "Studentgeting";
    }

    // Delete Student Page
    @GetMapping("/deletestu")
    public String deleteStudent() {
        return "Studentdelete";
    }

    // Insert Student
    @PostMapping("/inserting")
    @ResponseBody
    public String insert(@ModelAttribute Student student) {
        return studentDao.insert(student);
    }

    // Fetch Student by ID
    @GetMapping("/fetchid")
    @ResponseBody
    public Object fetchById(@RequestParam int id) {
        return studentDao.fetchByid(id);
    }

    // Fetch All Students
    @GetMapping("/fetchalls")
    @ResponseBody
    public Object fetchAll() {
        return studentDao.fetchall();
    }

    // Delete Student by ID
    @GetMapping("/deleteid")
    @ResponseBody
    public String deleteById(@RequestParam int id) {
        return studentDao.deltebyd(id);
    }

    // Delete All Students
    @GetMapping("/deletealls")
    @ResponseBody
    public String deleteAll() {
        return studentDao.deletell();
    }
}