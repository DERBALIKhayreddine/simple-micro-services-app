package tn.home.student.service;

import tn.home.student.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
    Student getStudentById(Long id);
    Object getStudentWithAddress(Long id);
}
