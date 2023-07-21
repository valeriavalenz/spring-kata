package com.ss.web.app.repository;

import com.ss.web.app.model.Student;
import com.ss.web.app.model.Subject;

import java.util.List;

public interface EnrollmentRepo {
  List<Student> listStudents(Subject subject);

  List<Subject> listSubjects(Student student);

  List<Student> listStudents(Long id);

  List<Subject> listSubjects(Long id);
}
