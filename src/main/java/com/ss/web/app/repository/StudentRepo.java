package com.ss.web.app.repository;

import com.ss.web.app.model.Student;

import java.util.List;

public interface StudentRepo {
  Student save(Student student);

  List<Student> findAll();

  Student edit(Student student);

  boolean delete(Student student);
}
