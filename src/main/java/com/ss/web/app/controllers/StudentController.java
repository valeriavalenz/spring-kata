package com.ss.web.app.controllers;

import com.ss.web.app.model.Student;
import com.ss.web.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
  @Autowired
  StudentService studentService;

  @GetMapping
  public List<Student> getAll() {
    return studentService.findAll();
  }

  @PostMapping("/create")
  public Student createStudent(@RequestBody Student student) {
    return studentService.addStudent(student);
  }

  @DeleteMapping("/delete")
  public boolean deleteStudent(@RequestBody Student student) {
    return studentService.delete(student);
  }

}
