package tn.home.student.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.home.student.entities.Student;
import tn.home.student.exceptions.StudentNotFoundException;
import tn.home.student.repositories.StudentRepository;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
}
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }
    @Override
    public Student updateStudent(Long id, Student student) {
        // Check if student exists
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));

        // Update student details
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // Save updated student
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        // Check if student exists
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));

        // Delete student
        studentRepository.delete(existingStudent);
    }
}