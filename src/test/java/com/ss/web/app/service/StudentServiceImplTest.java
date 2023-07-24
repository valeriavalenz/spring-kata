package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.repository.StudentRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

  @Test
  public void addStudent_AnStudent_StudentIsAddedCorrectlyAndReturned() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");

    when(repo.save(student)).thenReturn(student);
    Student studentExpected = studentServiceImpl.addStudent(student);

    assertNotNull(studentExpected);
    assertEquals(student, studentExpected);
  }

  @Test
  public void findAll_NoStudentsAdded_EmptyList() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);

    List<Student> students = new ArrayList<>();

    when(repo.findAll()).thenReturn(students);

    List<Student> studentsActual = studentServiceImpl.findAll();

    assertEquals(students.size(),studentsActual.size());
    assertEquals(students, studentsActual);
  }

  @Test
  public void findAll_OneStudentAdded_ListWithOneElement() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);

    List<Student> students = new ArrayList<>();
    students.add(new Student(3L, "Jorge", "Chavez"));

    when(repo.findAll()).thenReturn(students);

    List<Student> studentsActual = studentServiceImpl.findAll();

    assertNotNull(studentsActual);
    assertEquals(students, studentsActual);
  }

  @Test
  public void findAll_ManyStudentsAdded_ListWithAllStudents() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);

    List<Student> students = new ArrayList<>();
    students.add(new Student(2L, "Jose", "Perez"));
    students.add(new Student(3L, "Gabriel", "Vidal"));
    students.add(new Student(4L, "Lucas", "Lopez"));

    when(repo.findAll()).thenReturn(students);

    List<Student> studentsActual = studentServiceImpl.findAll();

    assertNotNull(studentsActual);
    assertEquals(students, studentsActual);
  }

  @Test
  public void delete_AddedStudent_True() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(2L, "Camila", "Perez");

    repo.save(student);
    when(repo.delete(student)).thenReturn(true);

    boolean actual = studentServiceImpl.delete(student);

    assertTrue(actual);
  }

  @Test
  public void delete_NonexistentStudent_False() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(1L, "Jorge", "Perez");

    when(repo.delete(student)).thenReturn(false);

    boolean actual = studentServiceImpl.delete(student);

    assertFalse(actual);
  }

  @Test
  public void edit_ExistentStudent_StudentWasEdited() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(1L, "Ignacio", "Solis");
    Student newStudent = new Student(1L, "Ignacio", "Soliz");

    repo.save(student);

    when(repo.edit(newStudent)).thenReturn(newStudent);
    Student actualStudent = studentServiceImpl.edit(newStudent);

    assertNotNull(actualStudent);
    assertEquals(newStudent, actualStudent);
  }

  @Test
  public void edit_NonexistentStudent_Null() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(1L, "Ignacio", "Solis");
    Student newStudent = new Student(1L, "Ignacio", "Soliz");


    Student actualStudent = studentServiceImpl.edit(newStudent);

    assertNull(actualStudent);
  }
}