package com.ss.web.app.service;

import com.ss.web.app.model.Student;

import java.util.List;

public interface StudentService {
  Student addStudent(Student student);

  List<Student> findAll();

  Student edit(Student student);

  boolean delete(Student student);
}
