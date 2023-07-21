package com.ss.web.app.model;


public class Enrollment {
  private Subject subject;
  private Student student;

  public Enrollment(Subject subject, Student student) {
    this.subject = subject;
    this.student = student;
  }


  public Subject getSubject() {
    return subject;
  }

  public Student getStudent() {
    return student;
  }
}