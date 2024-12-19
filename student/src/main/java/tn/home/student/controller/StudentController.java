package tn.home.student.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.home.student.entities.Student;
import tn.home.student.service.StudentService;

import java.util.List;
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET: Retrieve all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // POST: Create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // GET: Retrieve a student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // GET: Retrieve a student along with their address
    @GetMapping("/{id}/details")
    public Object getStudentWithAddress(@PathVariable Long id) {
        return studentService.getStudentWithAddress(id);
    }
}
