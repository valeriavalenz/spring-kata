package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService{

  private List<Student> students;
  private StudentRepo studentRepo;

  public StudentService(StudentRepo studentRepo) {
    this.students = new ArrayList<>();
    this.studentRepo = studentRepo;
  }

  public Student addStudent(Student student){
    return studentRepo.save(student);
  }

  public List<Student> findAll() {
    return studentRepo.findAll();
  }
}
