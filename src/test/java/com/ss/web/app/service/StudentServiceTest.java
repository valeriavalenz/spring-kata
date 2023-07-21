package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.repository.StudentRepo;
import com.ss.web.app.repository.StudentRepoImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

  @Test
  public void addStudent() {
    StudentRepo repo = new StudentRepoImpl();
    StudentService studentService = new StudentService(repo);
    Student student = new Student(4L, "ana", "perez");
    Student studentExpected = studentService.addStudent(student);

    assertEquals(student, studentExpected);
  }

//  @Test
//  public void findAllTest(){
//    StudentService studentService = new StudentService();
//    studentService
//  }
}