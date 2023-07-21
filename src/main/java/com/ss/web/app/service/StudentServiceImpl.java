package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepo studentRepo;

  public StudentServiceImpl(StudentRepo studentRepo) {
    this.studentRepo = studentRepo;
  }

  @Override
  public Student addStudent(Student student) {
    return studentRepo.save(student);
  }

  @Override
  public List<Student> findAll() {
    return studentRepo.findAll();
  }

  @Override
  public Student edit(Student student) {
    return studentRepo.edit(student);
  }

  @Override
  public boolean delete(Student student) {
    return studentRepo.delete(student);
  }
}
