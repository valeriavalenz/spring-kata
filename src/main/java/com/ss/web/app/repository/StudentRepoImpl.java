package com.ss.web.app.repository;

import com.ss.web.app.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepoImpl implements StudentRepo {
  private List<Student> studentList;

  public StudentRepoImpl() {
    studentList = new ArrayList<>();
    studentList.add(new Student(1L, "Sho", "Test"));
    studentList.add(new Student(2L, "Auto", "Test"));
    studentList.add(new Student(3L, "Curl", "Test"));
  }

  @Override
  public Student save(Student student) {
    studentList.add(student);
    return student;
  }

  @Override
  public List<Student> findAll() {
    return studentList;
  }

  @Override
  public Student edit(Student student) {
    studentList = studentList.stream()
            .filter(st -> !st.getId().equals(student.getId()))
            .collect(Collectors.toList());
    studentList.add(student);
    return student;
  }

  @Override
  public boolean delete(Student student) {
    return studentList.remove(student);
  }
}
